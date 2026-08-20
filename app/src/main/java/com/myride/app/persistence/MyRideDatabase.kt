package com.myride.app.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myride.app.persistence.dao.*
import com.myride.app.persistence.entity.*

@Database(
    entities = [
        VehicleEntity::class,
        MaintenanceEventEntity::class,
        MaintenanceTaskEntity::class,
        InspectionDefinitionEntity::class,
        InspectionSessionEntity::class,
        DiagnosticSessionEntity::class,
        ProcedureEntity::class,
        KnowledgeEntryEntity::class,
        AttachmentEntity::class,
        AppSettingEntity::class
    ],
    version = 2,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class MyRideDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
    abstract fun maintenanceEventDao(): MaintenanceEventDao
    abstract fun maintenanceTaskDao(): MaintenanceTaskDao
    abstract fun inspectionDefinitionDao(): InspectionDefinitionDao
    abstract fun inspectionSessionDao(): InspectionSessionDao
    abstract fun diagnosticSessionDao(): DiagnosticSessionDao
    abstract fun procedureDao(): ProcedureDao
    abstract fun knowledgeEntryDao(): KnowledgeEntryDao
    abstract fun attachmentDao(): AttachmentDao
    abstract fun appSettingDao(): AppSettingDao
}
