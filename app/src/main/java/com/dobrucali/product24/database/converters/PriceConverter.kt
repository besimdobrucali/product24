package com.dobrucali.product24.database.converters

import androidx.room.TypeConverter
import com.dobrucali.product24.data.entity.Price
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PriceConverter {
    @TypeConverter
    fun stringToPrice(json: String): Price? {
        val gson = Gson()
        val type = object : TypeToken<Price>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun priceToString(food: Price): String {
        val gson = Gson()
        val type = object : TypeToken<Price>() {}.type
        return gson.toJson(food, type)
    }
}
