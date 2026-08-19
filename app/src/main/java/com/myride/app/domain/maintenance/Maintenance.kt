package com.myride.app.domain.maintenance

import com.myride.app.domain.vehicle.VehicleId
import java.time.Instant
import java.util.UUID

@JvmInline
value class MaintenanceEventId(val value: String) {
    companion object { fun new() = MaintenanceEventId(UUID.randomUUID().toString()) }
}

enum class MaintenanceStatus { PLANNED, DUE, COMPLETED, SKIPPED, DEFERRED }

data class MaintenanceEvent(
    val id: MaintenanceEventId,
    val vehicleId: VehicleId,
    val occurredAt: Instant,
    val mileage: Long?,
    val category: String,
    val work: String,
    val partsMaterials: List<String> = emptyList(),
    val costMinorUnits: Long? = null,
    val notes: String? = null,
    val evidenceAttachmentIds: List<String> = emptyList()
)

data class MaintenanceTask(
    val id: String,
    val vehicleId: VehicleId,
    val description: String,
    val status: MaintenanceStatus,
    val dueAt: Instant? = null,
    val dueMileage: Long? = null
)
