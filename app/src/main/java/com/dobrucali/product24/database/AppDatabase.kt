package com.dobrucali.product24.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dobrucali.product24.data.FavouriteDao
import com.dobrucali.product24.data.entity.Price
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.database.converters.Converters
import com.dobrucali.product24.database.converters.PriceConverter
import com.dobrucali.product24.database.converters.ProductConverter

@Database(
    version = 1,
    entities = [ProductsItem::class, Price::class],
    exportSchema = false
)

@TypeConverters(
    Converters::class,
    ProductConverter::class,
    PriceConverter::class
)

abstract class AppDatabase : RoomDatabase() {
    abstract val favouriteDao: FavouriteDao
}