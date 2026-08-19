package com.myride.app.domain.diagnostic

interface DiagnosticRepository {
    fun get(sessionId: String): DiagnosticSession?
    fun save(session: DiagnosticSession)
    fun delete(sessionId: String)
}
