package com.myride.app.domain.maintenance

interface MaintenanceRepository {
    fun get(eventId: String): MaintenanceEvent?
    fun save(event: MaintenanceEvent)
    fun delete(eventId: String)
}
