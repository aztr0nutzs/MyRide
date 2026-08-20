package com.myride.app.persistence.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "diagnostic_sessions",
    foreignKeys = [ForeignKey(entity = VehicleEntity::class, parentColumns = ["id"], childColumns = ["vehicleId"], onDelete = ForeignKey.NO_ACTION)]
)
data class DiagnosticSessionEntity(
    @PrimaryKey val id: String,
    val vehicleId: String,
    val complaint: String,
    val context: String?,
    val observationIds: List<String>,
    val observationTimes: List<String>,
    val observationDescriptions: List<String>,
    val testIds: List<String>,
    val testDescriptions: List<String>,
    val testSafetyPrerequisites: List<String>,
    val resultIds: List<String>,
    val resultTestIds: List<String>,
    val resultOutcomes: List<String>,
    val resultMeasurements: List<String>,
    val hypothesisIds: List<String>,
    val hypothesisStatements: List<String>,
    val hypothesisStates: List<String>,
    val hypothesisSupportingEvidence: List<String>,
    val hypothesisContradictingEvidence: List<String>,
    val nextAction: String?,
    val outcome: String?
)
