package com.shibler.thefinalsjpc.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shibler.thefinalsjpc.R

@Entity(tableName = "BuildList_table")
data class BuildEntity(
    val listName: String,
    val classNumber:Int,
    var image: List<ItemData>,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

data class ItemData (
    var text: String ?= "akm",
    var image: Int ?= R.drawable.akm_sideview ,
    var type : Int ?= 0
)

internal class Converters {

    @TypeConverter
    fun fromList(value : List<ItemData>): String = Gson().toJson(value)


    @TypeConverter
    fun toList(value: String) : List<ItemData> = Gson().fromJson(value, object : TypeToken<List<ItemData>>() {}.type)

}