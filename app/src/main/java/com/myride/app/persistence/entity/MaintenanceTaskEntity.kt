package com.myride.app.persistence.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "maintenance_tasks",
    foreignKeys = [ForeignKey(entity = VehicleEntity::class, parentColumns = ["id"], childColumns = ["vehicleId"], onDelete = ForeignKey.NO_ACTION)]
)
data class MaintenanceTaskEntity(
    @PrimaryKey val id: String,
    val vehicleId: String,
    val description: String,
    val status: String,
    val dueAt: String?,
    val dueMileage: Long?
)
