package com.myride.app.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "procedures")
data class ProcedureEntity(
    @PrimaryKey val id: String,
    val title: String,
    val prerequisites: List<String>,
    val tools: List<String>,
    val parts: List<String>,
    val warnings: List<String>,
    val stepIds: List<String>,
    val stepOrders: List<Int>,
    val stepInstructions: List<String>,
    val stepObservationPrompts: List<String>
)
