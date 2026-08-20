package com.myride.app.persistence

import android.content.ContentValues
import android.database.Cursor
import android.util.Base64
import androidx.sqlite.db.SupportSQLiteDatabase
import org.json.JSONArray
import org.json.JSONObject
import java.time.Instant

/**
 * Versioned, transaction-safe database export/import.
 * Import is fully parsed and structurally validated before the existing data is mutated.
 * This is restore functionality, not schema migration; migrations remain in DatabaseMigrations.
 */
object DatabaseBackup {
    const val FORMAT_VERSION = 1
    private val TABLES = listOf(
        "vehicles", "maintenance_events", "maintenance_tasks", "inspection_definitions",
        "inspection_sessions", "diagnostic_sessions", "procedures", "knowledge_entries",
        "attachments", "app_settings"
    )

    fun export(database: SupportSQLiteDatabase, sourceDevice: String): String {
        val root = JSONObject()
            .put("formatVersion", FORMAT_VERSION)
            .put("schemaVersion", database.version)
            .put("applicationVersion", "0.1.0")
            .put("exportedAt", Instant.now().toString())
            .put("sourceDevice", sourceDevice)
        val records = JSONObject()
        TABLES.forEach { table -> records.put(table, exportTable(database, table)) }
        root.put("records", records)
        root.put("attachments", exportTable(database, "attachments"))
        return root.toString()
    }

    fun validate(input: String, database: SupportSQLiteDatabase): List<String> {
        val errors = mutableListOf<String>()
        val root = try { JSONObject(input) } catch (e: Exception) {
            return listOf("Invalid JSON: ${e.message ?: "parse failure"}")
        }
        if (root.optInt("formatVersion", -1) != FORMAT_VERSION) errors += "Unsupported formatVersion"
        if (root.optInt("schemaVersion", -1) != database.version) errors += "Unsupported schemaVersion"
        if (root.optString("applicationVersion").isBlank()) errors += "Missing applicationVersion"
        if (root.optString("exportedAt").isBlank()) errors += "Missing exportedAt"
        val records = root.optJSONObject("records") ?: return errors + "Missing records"
        TABLES.forEach { table ->
            val rows = records.optJSONArray(table) ?: errors.add("Missing records.$table")
            rows?.let { errors += validateTable(database, table, it) }
        }
        return errors.distinct()
    }

    fun import(database: SupportSQLiteDatabase, input: String) {
        val errors = validate(input, database)
        require(errors.isEmpty()) { "Backup validation failed: ${errors.joinToString("; ")}" }
        val records = JSONObject(input).getJSONObject("records")
        database.beginTransaction()
        try {
            // Restore is an explicit replacement operation. Schema migrations never use this path.
            TABLES.asReversed().forEach { database.delete(it, null, null) }
            TABLES.forEach { table ->
                val rows = records.getJSONArray(table)
                for (i in 0 until rows.length()) {
                    val values = toContentValues(rows.getJSONObject(i))
                    check(database.insert(table, 0, values) != -1L) { "Failed to restore row in $table" }
                }
            }
            database.setTransactionSuccessful()
        } finally {
            database.endTransaction()
        }
    }

    private fun exportTable(database: SupportSQLiteDatabase, table: String): JSONArray {
        val array = JSONArray()
        database.query("SELECT * FROM $table").use { cursor ->
            while (cursor.moveToNext()) {
                val row = JSONObject()
                for (i in 0 until cursor.columnCount) {
                    if (cursor.isNull(i)) row.put(cursor.getColumnName(i), JSONObject.NULL)
                    else when (cursor.getType(i)) {
                        Cursor.FIELD_TYPE_INTEGER -> row.put(cursor.getColumnName(i), cursor.getLong(i))
                        Cursor.FIELD_TYPE_FLOAT -> row.put(cursor.getColumnName(i), cursor.getDouble(i))
                        Cursor.FIELD_TYPE_BLOB -> row.put(cursor.getColumnName(i), Base64.encodeToString(cursor.getBlob(i), Base64.NO_WRAP))
                        else -> row.put(cursor.getColumnName(i), cursor.getString(i))
                    }
                }
                array.put(row)
            }
        }
        return array
    }

    private fun validateTable(database: SupportSQLiteDatabase, table: String, rows: JSONArray): List<String> {
        val errors = mutableListOf<String>()
        val expected = mutableSetOf<String>()
        database.query("PRAGMA table_info($table)").use { cursor ->
            val nameIndex = cursor.getColumnIndexOrThrow("name")
            while (cursor.moveToNext()) expected += cursor.getString(nameIndex)
        }
        val primaryKeys = mutableSetOf<String>()
        for (i in 0 until rows.length()) {
            val row = rows.optJSONObject(i) ?: run { errors += "$table[$i] is not an object"; continue }
            val keys = row.keys().asSequence().toSet()
            if (keys != expected) errors += "$table[$i] columns do not match schema"
            expected.filter { key -> row.isNull(key) }.forEach { key ->
                // Nullability is checked by SQLite during the transactional restore.
                if (key in setOf("id", "key")) errors += "$table[$i] has null primary key $key"
            }
            val pk = row.optString("id", row.optString("key", ""))
            if (pk.isNotBlank() && !primaryKeys.add(pk)) errors += "$table contains duplicate primary key $pk"
        }
        return errors
    }

    private fun toContentValues(row: JSONObject): ContentValues {
        val values = ContentValues()
        row.keys().forEach { key ->
            val value = row.get(key)
            when (value) {
                JSONObject.NULL -> values.putNull(key)
                is Boolean -> values.put(key, if (value) 1 else 0)
                is Int -> values.put(key, value)
                is Long -> values.put(key, value)
                is Double -> values.put(key, value)
                else -> values.put(key, value.toString())
            }
        }
        return values
    }
}
