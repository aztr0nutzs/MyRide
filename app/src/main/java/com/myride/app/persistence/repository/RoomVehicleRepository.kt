package com.myride.app.persistence.repository

import androidx.room.withTransaction
import com.myride.app.domain.vehicle.Vehicle
import com.myride.app.domain.vehicle.VehicleId
import com.myride.app.domain.vehicle.VehicleRepository
import com.myride.app.persistence.MyRideDatabase
import com.myride.app.persistence.mapper.toDomain
import com.myride.app.persistence.mapper.toEntity

class RoomVehicleRepository(
    private val database: MyRideDatabase
) : VehicleRepository {
    override suspend fun get(vehicleId: VehicleId): Vehicle? =
        database.vehicleDao().get(vehicleId.value)?.toDomain()

    override suspend fun save(vehicle: Vehicle) {
        database.withTransaction {
            database.vehicleDao().save(vehicle.toEntity())
        }
    }

    override suspend fun delete(vehicleId: VehicleId) {
        database.withTransaction {
            database.vehicleDao().get(vehicleId.value)?.let { database.vehicleDao().delete(it) }
        }
    }
}
