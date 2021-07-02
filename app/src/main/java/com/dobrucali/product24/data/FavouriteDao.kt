package com.dobrucali.product24.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dobrucali.product24.data.entity.ProductsItem

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavourite(product: ProductsItem)

    @Delete
    fun delete(product: ProductsItem)

    @Query("SELECT * FROM product")
    fun loadAllFavourites(): LiveData<List<ProductsItem>>

    @Query("DELETE FROM product")
    fun deleteAllFavourites()
}