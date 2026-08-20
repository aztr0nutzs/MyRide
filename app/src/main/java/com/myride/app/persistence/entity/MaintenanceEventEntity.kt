package com.myride.app.persistence.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "maintenance_events",
    foreignKeys = [ForeignKey(entity = VehicleEntity::class, parentColumns = ["id"], childColumns = ["vehicleId"], onDelete = ForeignKey.NO_ACTION)]
)
data class MaintenanceEventEntity(
    @PrimaryKey val id: String,
    val vehicleId: String,
    val occurredAt: String,
    val mileage: Long?,
    val category: String,
    val work: String,
    val partsMaterials: List<String>,
    val costMinorUnits: Long?,
    val notes: String?,
    val evidenceAttachmentIds: List<String>
)
