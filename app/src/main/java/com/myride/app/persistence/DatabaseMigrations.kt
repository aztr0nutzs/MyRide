package com.myride.app.persistence

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Explicit, non-destructive schema migrations. Existing rows are never deleted
 * as a migration strategy and the v1 vehicles table is preserved unchanged.
 */
object DatabaseMigrations {
    val V1_TO_V2 = object : Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("CREATE TABLE IF NOT EXISTS maintenance_events (id TEXT NOT NULL, vehicleId TEXT NOT NULL, occurredAt TEXT NOT NULL, mileage INTEGER, category TEXT NOT NULL, work TEXT NOT NULL, partsMaterials TEXT NOT NULL, costMinorUnits INTEGER, notes TEXT, evidenceAttachmentIds TEXT NOT NULL, PRIMARY KEY(id), FOREIGN KEY(vehicleId) REFERENCES vehicles(id) ON DELETE NO ACTION)")
            db.execSQL("CREATE INDEX IF NOT EXISTS index_maintenance_events_vehicleId ON maintenance_events(vehicleId)")
            db.execSQL("CREATE TABLE IF NOT EXISTS maintenance_tasks (id TEXT NOT NULL, vehicleId TEXT NOT NULL, description TEXT NOT NULL, status TEXT NOT NULL, dueAt TEXT, dueMileage INTEGER, PRIMARY KEY(id), FOREIGN KEY(vehicleId) REFERENCES vehicles(id) ON DELETE NO ACTION)")
            db.execSQL("CREATE INDEX IF NOT EXISTS index_maintenance_tasks_vehicleId ON maintenance_tasks(vehicleId)")
            db.execSQL("CREATE TABLE IF NOT EXISTS inspection_definitions (id TEXT NOT NULL, name TEXT NOT NULL, items TEXT NOT NULL, safetyCriticalItems TEXT NOT NULL, PRIMARY KEY(id))")
            db.execSQL("CREATE TABLE IF NOT EXISTS inspection_sessions (id TEXT NOT NULL, vehicleId TEXT NOT NULL, definitionId TEXT NOT NULL, startedAt TEXT NOT NULL, completedAt TEXT, resultItemIds TEXT NOT NULL, resultValues TEXT NOT NULL, resultNotes TEXT NOT NULL, resultAttachmentIds TEXT NOT NULL, PRIMARY KEY(id), FOREIGN KEY(vehicleId) REFERENCES vehicles(id) ON DELETE NO ACTION)")
            db.execSQL("CREATE INDEX IF NOT EXISTS index_inspection_sessions_vehicleId ON inspection_sessions(vehicleId)")
            db.execSQL("CREATE TABLE IF NOT EXISTS diagnostic_sessions (id TEXT NOT NULL, vehicleId TEXT NOT NULL, complaint TEXT NOT NULL, context TEXT, observationIds TEXT NOT NULL, observationTimes TEXT NOT NULL, observationDescriptions TEXT NOT NULL, testIds TEXT NOT NULL, testDescriptions TEXT NOT NULL, testSafetyPrerequisites TEXT NOT NULL, resultIds TEXT NOT NULL, resultTestIds TEXT NOT NULL, resultOutcomes TEXT NOT NULL, resultMeasurements TEXT NOT NULL, hypothesisIds TEXT NOT NULL, hypothesisStatements TEXT NOT NULL, hypothesisStates TEXT NOT NULL, hypothesisSupportingEvidence TEXT NOT NULL, hypothesisContradictingEvidence TEXT NOT NULL, nextAction TEXT, outcome TEXT, PRIMARY KEY(id), FOREIGN KEY(vehicleId) REFERENCES vehicles(id) ON DELETE NO ACTION)")
            db.execSQL("CREATE INDEX IF NOT EXISTS index_diagnostic_sessions_vehicleId ON diagnostic_sessions(vehicleId)")
            db.execSQL("CREATE TABLE IF NOT EXISTS procedures (id TEXT NOT NULL, title TEXT NOT NULL, prerequisites TEXT NOT NULL, tools TEXT NOT NULL, parts TEXT NOT NULL, warnings TEXT NOT NULL, stepIds TEXT NOT NULL, stepOrders TEXT NOT NULL, stepInstructions TEXT NOT NULL, stepObservationPrompts TEXT NOT NULL, PRIMARY KEY(id))")
            db.execSQL("CREATE TABLE IF NOT EXISTS knowledge_entries (id TEXT NOT NULL, title TEXT NOT NULL, content TEXT NOT NULL, knowledgeClass TEXT NOT NULL, verificationState TEXT NOT NULL, applicabilityYear INTEGER, applicabilityEngine TEXT, applicabilityTransmission TEXT, applicabilityDrivetrain TEXT, applicabilityTrim TEXT, applicabilityCabBody TEXT, applicabilityProduction TEXT, applicabilityMarket TEXT, applicabilityOptionalEquipment TEXT NOT NULL, sourceTitles TEXT NOT NULL, sourcePublishers TEXT NOT NULL, sourcePublicationVersions TEXT NOT NULL, sourceSectionReferences TEXT NOT NULL, sourceRetrievalDates TEXT NOT NULL, sourceReviewers TEXT NOT NULL, sourceNotes TEXT NOT NULL, safetyCritical INTEGER NOT NULL, PRIMARY KEY(id))")
            db.execSQL("CREATE TABLE IF NOT EXISTS attachments (id TEXT NOT NULL, ownerType TEXT NOT NULL, ownerId TEXT NOT NULL, fileName TEXT NOT NULL, mediaType TEXT NOT NULL, relativePath TEXT NOT NULL, byteSize INTEGER NOT NULL, sha256 TEXT, PRIMARY KEY(id))")
            db.execSQL("CREATE INDEX IF NOT EXISTS index_attachments_ownerId ON attachments(ownerId)")
            db.execSQL("CREATE TABLE IF NOT EXISTS app_settings (`key` TEXT NOT NULL, value TEXT NOT NULL, updatedAt TEXT NOT NULL, PRIMARY KEY(`key`))")
        }
    }

    val ALL: Array<Migration> = arrayOf(V1_TO_V2)
}
