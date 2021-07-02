package com.dobrucali.product24.database.converters

import androidx.room.TypeConverter
import com.dobrucali.product24.data.entity.ProductsItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductConverter {
    @TypeConverter
    fun stringToProduct(json: String): ProductsItem? {
        val gson = Gson()
        val type = object : TypeToken<ProductsItem>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun productToString(food: ProductsItem): String {
        val gson = Gson()
        val type = object : TypeToken<ProductsItem>() {}.type
        return gson.toJson(food, type)
    }
}
