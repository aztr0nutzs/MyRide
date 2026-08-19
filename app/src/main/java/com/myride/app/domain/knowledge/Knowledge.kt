package com.myride.app.domain.knowledge

import com.myride.app.domain.vehicle.VehicleConfiguration
import java.time.LocalDate
import java.util.UUID

@JvmInline
value class KnowledgeEntryId(val value: String) {
    companion object { fun new() = KnowledgeEntryId(UUID.randomUUID().toString()) }
}

enum class KnowledgeClass { VERIFIED_SPECIFICATION, GENERAL_GUIDANCE, USER_OBSERVATION, DIAGNOSTIC_HYPOTHESIS, DERIVED_VALUE, UNKNOWN }
enum class VerificationState { DRAFT, SOURCED, REVIEWED, VERIFIED, PUBLISHED, SUPERSEDED }

data class Applicability(
    val year: Int? = null,
    val engine: String? = null,
    val transmission: String? = null,
    val drivetrain: String? = null,
    val trim: String? = null,
    val cabBody: String? = null,
    val production: String? = null,
    val market: String? = null,
    val optionalEquipment: Set<String> = emptySet()
) {
    fun appliesTo(configuration: VehicleConfiguration): Boolean {
        return matches(year, configuration.year.value) &&
            matches(engine, configuration.engine.value) &&
            matches(transmission, configuration.transmission.value) &&
            matches(drivetrain, configuration.drivetrain.value) &&
            matches(trim, configuration.trim.value) &&
            matches(cabBody, configuration.cabBody.value) &&
            matches(production, configuration.production.value) &&
            matches(market, configuration.market.value)
    }

    private fun <T> matches(required: T?, actual: T?): Boolean = required == null || required == actual
}

data class KnowledgeSource(
    val title: String,
    val publisher: String,
    val publicationVersion: String? = null,
    val sectionReference: String? = null,
    val retrievalDate: LocalDate? = null,
    val reviewer: String? = null,
    val notes: String? = null
)

data class KnowledgeEntry(
    val id: KnowledgeEntryId,
    val title: String,
    val content: String,
    val knowledgeClass: KnowledgeClass,
    val verificationState: VerificationState,
    val applicability: Applicability? = null,
    val sources: List<KnowledgeSource> = emptyList(),
    val safetyCritical: Boolean = false
)
