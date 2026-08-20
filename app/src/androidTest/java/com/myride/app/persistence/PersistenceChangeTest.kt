package com.myride.app.persistence

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.myride.app.persistence.entity.MaintenanceEventEntity
import com.myride.app.persistence.entity.VehicleEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PersistenceChangeTest {
    private lateinit var database: MyRideDatabase
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        database = Room.inMemoryDatabaseBuilder(context, MyRideDatabase::class.java).build()
    }

    @After
    fun tearDown() = database.close()

    @Test
    fun emptyDatabaseHasNoRecordsAndExportsValidDocument() = runBlocking {
        assertEquals(null, database.vehicleDao().get("missing"))
        val exported = DatabaseBackup.export(database.openHelper.writableDatabase, "instrumented-test")
        assertTrue(DatabaseBackup.validate(exported, database.openHelper.writableDatabase).isEmpty())
    }

    @Test
    fun populatedDatabasePreservesStableIdsAndRelationshipsThroughBackupRestore() = runBlocking {
        val vehicle = vehicle("vehicle-1")
        database.vehicleDao().save(vehicle)
        database.maintenanceEventDao().save(
            MaintenanceEventEntity(
                id = "maintenance-1",
                vehicleId = vehicle.id,
                occurredAt = "2026-08-19T20:00:00Z",
                mileage = 123456,
                category = "inspection",
                work = "Baseline inspection",
                partsMaterials = emptyList(),
                costMinorUnits = 0,
                notes = "Preserve this record",
                evidenceAttachmentIds = emptyList()
            )
        )

        val db = database.openHelper.writableDatabase
        val exported = DatabaseBackup.export(db, "instrumented-test")
        assertTrue(DatabaseBackup.validate(exported, db).isEmpty())

        db.delete("maintenance_events", null, null)
        db.delete("vehicles", null, null)
        DatabaseBackup.import(db, exported)

        assertEquals(vehicle.id, database.vehicleDao().get(vehicle.id)?.id)
        assertEquals(vehicle.id, database.maintenanceEventDao().get("maintenance-1")?.vehicleId)
        assertEquals("Preserve this record", database.maintenanceEventDao().get("maintenance-1")?.notes)
    }

    @Test
    fun invalidImportIsRejectedBeforeMutation() = runBlocking {
        val vehicle = vehicle("protected-vehicle")
        database.vehicleDao().save(vehicle)
        val db = database.openHelper.writableDatabase
        val invalid = "{\"formatVersion\":999,\"schemaVersion\":2,\"applicationVersion\":\"0.1.0\",\"exportedAt\":\"2026-08-19T20:00:00Z\",\"records\":{}}"

        val errors = DatabaseBackup.validate(invalid, db)
        assertTrue(errors.isNotEmpty())
        try {
            DatabaseBackup.import(db, invalid)
            throw AssertionError("Invalid import unexpectedly succeeded")
        } catch (_: IllegalArgumentException) {
            // Expected. No mutation is permitted before validation succeeds.
        }
        assertEquals(vehicle.id, database.vehicleDao().get(vehicle.id)?.id)
    }

    @Test
    fun duplicatePrimaryKeyIsRejected() = runBlocking {
        val db = database.openHelper.writableDatabase
        val exported = DatabaseBackup.export(db, "instrumented-test")
        val duplicated = exported.replace("\"vehicles\":[]", "\"vehicles\":[{\"id\":\"same\"},{\"id\":\"same\"}]")
        val errors = DatabaseBackup.validate(duplicated, db)
        assertTrue(errors.any { it.contains("duplicate primary key") })
    }

    private fun vehicle(id: String) = VehicleEntity(
        id = id,
        vin = null,
        vinState = "UNKNOWN",
        year = null,
        yearState = "UNKNOWN",
        make = null,
        makeState = "UNKNOWN",
        model = null,
        modelState = "UNKNOWN",
        trim = null,
        trimState = "UNKNOWN",
        engine = null,
        engineState = "UNKNOWN",
        transmission = null,
        transmissionState = "UNKNOWN",
        drivetrain = null,
        drivetrainState = "UNKNOWN",
        cabBody = null,
        cabBodyState = "UNKNOWN",
        market = null,
        marketState = "UNKNOWN",
        production = null,
        productionState = "UNKNOWN",
        mileage = null,
        mileageState = "UNKNOWN",
        optionalEquipment = emptyList(),
        archived = false
    )
}
