package com.myride.app.persistence

import androidx.room.TypeConverter
import java.time.Instant

class Converters {
    @TypeConverter
    fun instantToString(value: Instant?): String? = value?.toString()

    @TypeConverter
    fun stringToInstant(value: String?): Instant? = value?.let(Instant::parse)

    @TypeConverter
    fun stringListToString(value: List<String>?): String? = value?.joinToString("\u001F")

    @TypeConverter
    fun stringToStringList(value: String?): List<String> =
        value?.takeIf { it.isNotEmpty() }?.split("\u001F") ?: emptyList()
}
