package com.myride.app.domain.maintenance

interface MaintenanceRepository {
    suspend fun get(eventId: String): MaintenanceEvent?
    suspend fun save(event: MaintenanceEvent)
    suspend fun delete(eventId: String)
}
