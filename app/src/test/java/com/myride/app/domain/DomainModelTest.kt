package com.myride.app.domain

import com.myride.app.domain.diagnostic.DiagnosticHypothesis
import com.myride.app.domain.diagnostic.HypothesisState
import com.myride.app.domain.knowledge.Applicability
import com.myride.app.domain.knowledge.KnowledgeClass
import com.myride.app.domain.knowledge.KnowledgeEntry
import com.myride.app.domain.knowledge.KnowledgeEntryId
import com.myride.app.domain.knowledge.VerificationState
import com.myride.app.domain.vehicle.ConfigurationValue
import com.myride.app.domain.vehicle.ConfigurationValueState
import com.myride.app.domain.vehicle.VehicleConfiguration
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DomainModelTest {
    @Test
    fun unknownConfigurationIsRepresentable() {
        val configuration = VehicleConfiguration()
        assertEquals(ConfigurationValueState.UNKNOWN, configuration.engine.state)
        assertEquals(null, configuration.engine.value)
    }

    @Test
    fun verificationStateIsNotInferredFromPresenceOfValue() {
        val engine = ConfigurationValue("unknown-to-be-verified", ConfigurationValueState.USER_PROVIDED_UNVERIFIED)
        assertEquals(ConfigurationValueState.USER_PROVIDED_UNVERIFIED, engine.state)
    }

    @Test
    fun applicabilityMatchesOnlySpecifiedDimensions() {
        val configuration = VehicleConfiguration(
            year = ConfigurationValue(1997, ConfigurationValueState.USER_PROVIDED_UNVERIFIED),
            engine = ConfigurationValue("example", ConfigurationValueState.UNKNOWN)
        )
        assertTrue(Applicability(year = 1997).appliesTo(configuration))
        assertFalse(Applicability(year = 1998).appliesTo(configuration))
    }

    @Test
    fun diagnosticHypothesisRetainsEvidenceAndState() {
        val hypothesis = DiagnosticHypothesis(
            id = "h1",
            sessionId = com.myride.app.domain.diagnostic.DiagnosticSessionId("s1"),
            statement = "Possible cause",
            state = HypothesisState.SUPPORTED,
            supportingEvidenceIds = listOf("observation-1")
        )
        assertEquals(HypothesisState.SUPPORTED, hypothesis.state)
        assertEquals(listOf("observation-1"), hypothesis.supportingEvidenceIds)
    }

    @Test
    fun knowledgeEntryCanRemainUnverified() {
        val entry = KnowledgeEntry(
            id = KnowledgeEntryId("k1"),
            title = "Example",
            content = "Not yet verified",
            knowledgeClass = KnowledgeClass.UNKNOWN,
            verificationState = VerificationState.DRAFT
        )
        assertEquals(KnowledgeClass.UNKNOWN, entry.knowledgeClass)
        assertEquals(VerificationState.DRAFT, entry.verificationState)
    }
}
