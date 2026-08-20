package com.myride.app.persistence

import androidx.room.migration.Migration

/**
 * Central registry for explicit database migrations.
 *
 * Version 1 is the initial schema and therefore has no predecessor migration.
 * Future schema changes must add a concrete Migration here rather than deleting
 * or recreating the database.
 */
object DatabaseMigrations {
    val ALL: Array<Migration> = emptyArray()
}
