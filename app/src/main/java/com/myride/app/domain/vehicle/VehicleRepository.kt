package com.myride.app.domain.vehicle

interface VehicleRepository {
    fun get(vehicleId: VehicleId): Vehicle?
    fun save(vehicle: Vehicle)
    fun delete(vehicleId: VehicleId)
}
