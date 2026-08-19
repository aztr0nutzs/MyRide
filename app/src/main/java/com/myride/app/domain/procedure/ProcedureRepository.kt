package com.myride.app.domain.procedure

interface ProcedureRepository {
    fun get(procedureId: String): Procedure?
    fun save(procedure: Procedure)
    fun delete(procedureId: String)
}
