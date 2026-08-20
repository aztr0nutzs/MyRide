package com.myride.app.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class VehicleEntity(
    @PrimaryKey val id: String,
    val vin: String?,
    val vinState: String,
    val year: Int?,
    val yearState: String,
    val make: String?,
    val makeState: String,
    val model: String?,
    val modelState: String,
    val trim: String?,
    val trimState: String,
    val engine: String?,
    val engineState: String,
    val transmission: String?,
    val transmissionState: String,
    val drivetrain: String?,
    val drivetrainState: String,
    val cabBody: String?,
    val cabBodyState: String,
    val market: String?,
    val marketState: String,
    val production: String?,
    val productionState: String,
    val mileage: Long?,
    val mileageState: String,
    val optionalEquipment: List<String>,
    val archived: Boolean
)
