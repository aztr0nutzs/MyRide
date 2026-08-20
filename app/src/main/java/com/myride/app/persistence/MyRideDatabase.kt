package com.myride.app.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myride.app.persistence.dao.VehicleDao
import com.myride.app.persistence.entity.VehicleEntity

@Database(
    entities = [VehicleEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class MyRideDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}
