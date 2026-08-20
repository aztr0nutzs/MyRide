package com.myride.app.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "knowledge_entries")
data class KnowledgeEntryEntity(
    @PrimaryKey val id: String,
    val title: String,
    val content: String,
    val knowledgeClass: String,
    val verificationState: String,
    val applicabilityYear: Int?,
    val applicabilityEngine: String?,
    val applicabilityTransmission: String?,
    val applicabilityDrivetrain: String?,
    val applicabilityTrim: String?,
    val applicabilityCabBody: String?,
    val applicabilityProduction: String?,
    val applicabilityMarket: String?,
    val applicabilityOptionalEquipment: List<String>,
    val sourceTitles: List<String>,
    val sourcePublishers: List<String>,
    val sourcePublicationVersions: List<String>,
    val sourceSectionReferences: List<String>,
    val sourceRetrievalDates: List<String>,
    val sourceReviewers: List<String>,
    val sourceNotes: List<String>,
    val safetyCritical: Boolean
)
