package com.myride.app.domain.safety

enum class SafetySeverity { INFO, CAUTION, WARNING, DANGER }

data class SafetyRule(
    val id: String,
    val title: String,
    val instruction: String,
    val severity: SafetySeverity,
    val prerequisite: String? = null
)

data class SafetyGate(
    val rule: SafetyRule,
    val satisfied: Boolean = false
) {
    fun mayProceed(): Boolean = satisfied || rule.severity == SafetySeverity.INFO
}
