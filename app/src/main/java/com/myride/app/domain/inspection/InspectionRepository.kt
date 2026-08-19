package com.myride.app.domain.inspection

interface InspectionRepository {
    fun get(sessionId: String): InspectionSession?
    fun save(session: InspectionSession)
    fun delete(sessionId: String)
}
