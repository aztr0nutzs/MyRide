package com.myride.app.domain.inspection

import com.myride.app.domain.vehicle.VehicleId
import java.time.Instant
import java.util.UUID

@JvmInline
value class InspectionDefinitionId(val value: String)

@JvmInline
value class InspectionSessionId(val value: String) {
    companion object { fun new() = InspectionSessionId(UUID.randomUUID().toString()) }
}

data class InspectionItem(
    val id: String,
    val prompt: String,
    val safetyCritical: Boolean = false
)

data class InspectionDefinition(
    val id: InspectionDefinitionId,
    val name: String,
    val items: List<InspectionItem>
)

data class InspectionItemResult(
    val itemId: String,
    val result: String,
    val notes: String? = null,
    val attachmentIds: List<String> = emptyList()
)

data class InspectionSession(
    val id: InspectionSessionId,
    val vehicleId: VehicleId,
    val definitionId: InspectionDefinitionId,
    val startedAt: Instant,
    val completedAt: Instant? = null,
    val results: List<InspectionItemResult> = emptyList()
)
