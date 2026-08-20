package com.myride.app.persistence

import android.content.Context
import androidx.room.Room

object MyRideDatabaseFactory {
    private const val DATABASE_NAME = "myride.db"

    fun create(context: Context): MyRideDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            MyRideDatabase::class.java,
            DATABASE_NAME
        )
            .addMigrations(*DatabaseMigrations.ALL)
            .build()
}
