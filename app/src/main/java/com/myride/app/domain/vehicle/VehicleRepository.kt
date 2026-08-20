package com.myride.app.domain.vehicle

interface VehicleRepository {
    suspend fun get(vehicleId: VehicleId): Vehicle?
    suspend fun save(vehicle: Vehicle)
    suspend fun delete(vehicleId: VehicleId)
}
