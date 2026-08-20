package com.myride.app.persistence

import com.myride.app.domain.vehicle.ConfigurationValue
import com.myride.app.domain.vehicle.ConfigurationValueState
import com.myride.app.domain.vehicle.Vehicle
import com.myride.app.domain.vehicle.VehicleConfiguration
import com.myride.app.domain.vehicle.VehicleId
import com.myride.app.persistence.mapper.toDomain
import com.myride.app.persistence.mapper.toEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class VehicleMapperTest {
    @Test
    fun roundTripPreservesUnknownConfigurationStates() {
        val vehicle = Vehicle(
            id = VehicleId("vehicle-1"),
            vin = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
            configuration = VehicleConfiguration(
                year = ConfigurationValue(1997, ConfigurationValueState.USER_PROVIDED_UNVERIFIED),
                engine = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
                optionalEquipment = listOf("unknown")
            )
        )

        val restored = vehicle.toEntity().toDomain()

        assertEquals(vehicle, restored)
    }
}
