package com.myride.app.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myride.app.persistence.entity.*

@Dao
interface MaintenanceEventDao {
    @Query("SELECT * FROM maintenance_events WHERE id = :id") suspend fun get(id: String): MaintenanceEventEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: MaintenanceEventEntity)
    @Delete suspend fun delete(entity: MaintenanceEventEntity)
}

@Dao
interface MaintenanceTaskDao {
    @Query("SELECT * FROM maintenance_tasks WHERE id = :id") suspend fun get(id: String): MaintenanceTaskEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: MaintenanceTaskEntity)
    @Delete suspend fun delete(entity: MaintenanceTaskEntity)
}

@Dao
interface InspectionDefinitionDao {
    @Query("SELECT * FROM inspection_definitions WHERE id = :id") suspend fun get(id: String): InspectionDefinitionEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: InspectionDefinitionEntity)
    @Delete suspend fun delete(entity: InspectionDefinitionEntity)
}

@Dao
interface InspectionSessionDao {
    @Query("SELECT * FROM inspection_sessions WHERE id = :id") suspend fun get(id: String): InspectionSessionEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: InspectionSessionEntity)
    @Delete suspend fun delete(entity: InspectionSessionEntity)
}

@Dao
interface DiagnosticSessionDao {
    @Query("SELECT * FROM diagnostic_sessions WHERE id = :id") suspend fun get(id: String): DiagnosticSessionEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: DiagnosticSessionEntity)
    @Delete suspend fun delete(entity: DiagnosticSessionEntity)
}

@Dao
interface ProcedureDao {
    @Query("SELECT * FROM procedures WHERE id = :id") suspend fun get(id: String): ProcedureEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: ProcedureEntity)
    @Delete suspend fun delete(entity: ProcedureEntity)
}

@Dao
interface KnowledgeEntryDao {
    @Query("SELECT * FROM knowledge_entries WHERE id = :id") suspend fun get(id: String): KnowledgeEntryEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: KnowledgeEntryEntity)
    @Delete suspend fun delete(entity: KnowledgeEntryEntity)
}

@Dao
interface AttachmentDao {
    @Query("SELECT * FROM attachments WHERE id = :id") suspend fun get(id: String): AttachmentEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: AttachmentEntity)
    @Delete suspend fun delete(entity: AttachmentEntity)
}

@Dao
interface AppSettingDao {
    @Query("SELECT * FROM app_settings WHERE `key` = :key") suspend fun get(key: String): AppSettingEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: AppSettingEntity)
    @Delete suspend fun delete(entity: AppSettingEntity)
}
