package com.myride.app.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myride.app.persistence.entity.VehicleEntity

@Dao
interface VehicleDao {
    @Query("SELECT * FROM vehicles WHERE id = :id")
    suspend fun get(id: String): VehicleEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entity: VehicleEntity)

    @Delete
    suspend fun delete(entity: VehicleEntity)
}
