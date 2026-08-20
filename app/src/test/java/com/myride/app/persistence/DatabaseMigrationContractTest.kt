package com.myride.app.persistence

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class DatabaseMigrationContractTest {
    @Test
    fun targetSchemaUsesExplicitV1ToV2Migration() {
        assertEquals(1, DatabaseMigrations.V1_TO_V2.startVersion)
        assertEquals(2, DatabaseMigrations.V1_TO_V2.endVersion)
        assertFalse(DatabaseMigrations.ALL.isEmpty())
        assertEquals(DatabaseMigrations.V1_TO_V2, DatabaseMigrations.ALL.single())
    }
}
