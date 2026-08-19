package com.myride.app.domain.vehicle

import java.util.UUID

@JvmInline
value class VehicleId(val value: String) {
    companion object {
        fun new(): VehicleId = VehicleId(UUID.randomUUID().toString())
    }
}

enum class ConfigurationValueState {
    VERIFIED,
    USER_PROVIDED_UNVERIFIED,
    INFERRED,
    UNKNOWN
}

data class ConfigurationValue<T>(
    val value: T?,
    val state: ConfigurationValueState
)

data class VehicleConfiguration(
    val year: ConfigurationValue<Int> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val make: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val model: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val trim: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val engine: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val transmission: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val drivetrain: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val cabBody: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val market: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val production: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val mileage: ConfigurationValue<Long> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val optionalEquipment: List<String> = emptyList()
)

data class Vehicle(
    val id: VehicleId,
    val vin: ConfigurationValue<String> = ConfigurationValue(null, ConfigurationValueState.UNKNOWN),
    val configuration: VehicleConfiguration = VehicleConfiguration(),
    val archived: Boolean = false
)
