package com.myride.app.domain.inspection

interface InspectionRepository {
    suspend fun get(sessionId: String): InspectionSession?
    suspend fun save(session: InspectionSession)
    suspend fun delete(sessionId: String)
}
