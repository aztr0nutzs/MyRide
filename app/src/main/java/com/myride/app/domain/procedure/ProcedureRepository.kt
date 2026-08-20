package com.myride.app.domain.procedure

interface ProcedureRepository {
    suspend fun get(procedureId: String): Procedure?
    suspend fun save(procedure: Procedure)
    suspend fun delete(procedureId: String)
}
