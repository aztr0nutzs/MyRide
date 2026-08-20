package com.myride.app.persistence.mapper

import com.myride.app.domain.vehicle.ConfigurationValue
import com.myride.app.domain.vehicle.ConfigurationValueState
import com.myride.app.domain.vehicle.Vehicle
import com.myride.app.domain.vehicle.VehicleConfiguration
import com.myride.app.domain.vehicle.VehicleId
import com.myride.app.persistence.entity.VehicleEntity

fun Vehicle.toEntity(): VehicleEntity = VehicleEntity(
    id = id.value,
    vin = vin.value,
    vinState = vin.state.name,
    year = configuration.year.value,
    yearState = configuration.year.state.name,
    make = configuration.make.value,
    makeState = configuration.make.state.name,
    model = configuration.model.value,
    modelState = configuration.model.state.name,
    trim = configuration.trim.value,
    trimState = configuration.trim.state.name,
    engine = configuration.engine.value,
    engineState = configuration.engine.state.name,
    transmission = configuration.transmission.value,
    transmissionState = configuration.transmission.state.name,
    drivetrain = configuration.drivetrain.value,
    drivetrainState = configuration.drivetrain.state.name,
    cabBody = configuration.cabBody.value,
    cabBodyState = configuration.cabBody.state.name,
    market = configuration.market.value,
    marketState = configuration.market.state.name,
    production = configuration.production.value,
    productionState = configuration.production.state.name,
    mileage = configuration.mileage.value,
    mileageState = configuration.mileage.state.name,
    optionalEquipment = configuration.optionalEquipment,
    archived = archived
)

fun VehicleEntity.toDomain(): Vehicle = Vehicle(
    id = VehicleId(id),
    vin = ConfigurationValue(vin, ConfigurationValueState.valueOf(vinState)),
    configuration = VehicleConfiguration(
        year = ConfigurationValue(year, ConfigurationValueState.valueOf(yearState)),
        make = ConfigurationValue(make, ConfigurationValueState.valueOf(makeState)),
        model = ConfigurationValue(model, ConfigurationValueState.valueOf(modelState)),
        trim = ConfigurationValue(trim, ConfigurationValueState.valueOf(trimState)),
        engine = ConfigurationValue(engine, ConfigurationValueState.valueOf(engineState)),
        transmission = ConfigurationValue(transmission, ConfigurationValueState.valueOf(transmissionState)),
        drivetrain = ConfigurationValue(drivetrain, ConfigurationValueState.valueOf(drivetrainState)),
        cabBody = ConfigurationValue(cabBody, ConfigurationValueState.valueOf(cabBodyState)),
        market = ConfigurationValue(market, ConfigurationValueState.valueOf(marketState)),
        production = ConfigurationValue(production, ConfigurationValueState.valueOf(productionState)),
        mileage = ConfigurationValue(mileage, ConfigurationValueState.valueOf(mileageState)),
        optionalEquipment = optionalEquipment
    ),
    archived = archived
)
