package com.myride.app.domain.diagnostic

import com.myride.app.domain.vehicle.VehicleId
import java.time.Instant
import java.util.UUID

@JvmInline
value class DiagnosticSessionId(val value: String) {
    companion object { fun new() = DiagnosticSessionId(UUID.randomUUID().toString()) }
}

enum class HypothesisState { POSSIBLE, LIKELY, SUPPORTED, CONFIRMED, REJECTED }

data class DiagnosticObservation(
    val id: String,
    val sessionId: DiagnosticSessionId,
    val recordedAt: Instant,
    val description: String
)

data class DiagnosticTest(
    val id: String,
    val sessionId: DiagnosticSessionId,
    val description: String,
    val safetyPrerequisite: String? = null
)

data class DiagnosticResult(
    val id: String,
    val testId: String,
    val outcome: String,
    val measurement: String? = null
)

data class DiagnosticHypothesis(
    val id: String,
    val sessionId: DiagnosticSessionId,
    val statement: String,
    val state: HypothesisState = HypothesisState.POSSIBLE,
    val supportingEvidenceIds: List<String> = emptyList(),
    val contradictingEvidenceIds: List<String> = emptyList()
)

data class DiagnosticSession(
    val id: DiagnosticSessionId,
    val vehicleId: VehicleId,
    val complaint: String,
    val context: String? = null,
    val observations: List<DiagnosticObservation> = emptyList(),
    val tests: List<DiagnosticTest> = emptyList(),
    val results: List<DiagnosticResult> = emptyList(),
    val hypotheses: List<DiagnosticHypothesis> = emptyList(),
    val nextAction: String? = null,
    val outcome: String? = null
)
