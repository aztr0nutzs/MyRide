package com.myride.app.persistence.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "inspection_definitions")
data class InspectionDefinitionEntity(
    @PrimaryKey val id: String,
    val name: String,
    val items: List<String>,
    val safetyCriticalItems: List<String>
)

@Entity(
    tableName = "inspection_sessions",
    foreignKeys = [ForeignKey(entity = VehicleEntity::class, parentColumns = ["id"], childColumns = ["vehicleId"], onDelete = ForeignKey.NO_ACTION)]
)
data class InspectionSessionEntity(
    @PrimaryKey val id: String,
    val vehicleId: String,
    val definitionId: String,
    val startedAt: String,
    val completedAt: String?,
    val resultItemIds: List<String>,
    val resultValues: List<String>,
    val resultNotes: List<String>,
    val resultAttachmentIds: List<String>
)
