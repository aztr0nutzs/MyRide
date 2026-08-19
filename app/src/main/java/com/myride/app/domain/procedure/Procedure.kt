package com.myride.app.domain.procedure

import java.util.UUID

@JvmInline
value class ProcedureId(val value: String) {
    companion object { fun new() = ProcedureId(UUID.randomUUID().toString()) }
}

data class ProcedureStep(
    val id: String,
    val order: Int,
    val instruction: String,
    val observationPrompt: String? = null
)

data class Procedure(
    val id: ProcedureId,
    val title: String,
    val prerequisites: List<String> = emptyList(),
    val tools: List<String> = emptyList(),
    val parts: List<String> = emptyList(),
    val warnings: List<String> = emptyList(),
    val steps: List<ProcedureStep> = emptyList()
)
