package com.myride.app.domain.diagnostic

interface DiagnosticRepository {
    suspend fun get(sessionId: String): DiagnosticSession?
    suspend fun save(session: DiagnosticSession)
    suspend fun delete(sessionId: String)
}
