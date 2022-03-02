package com.lsj.newsdemoapp.data.model.db

import androidx.room.TypeConverter
import com.lsj.newsdemoapp.data.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}