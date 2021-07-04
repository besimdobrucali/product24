package com.dobrucali.product24.data.repository

import androidx.lifecycle.LiveData
import com.dobrucali.product24.data.FavouriteDao
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.data.error.getResourceFromThrowable
import com.dobrucali.product24.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavouriteRepository(
    val favouriteDao: FavouriteDao
) {

    fun getFavouriteProductList(): LiveData<List<ProductsItem>> {
        return favouriteDao.loadAllFavourites()
    }

    suspend fun addFavourite(productsItem: ProductsItem): Resource<Boolean> {
        return try {
            withContext(Dispatchers.IO) {
                favouriteDao.insertFavourite(productsItem)
                Resource.success(data = true)
            }
        } catch (cause: Throwable) {
            getResourceFromThrowable(cause)
        }
    }

    suspend fun removeFavourite(productsItem: ProductsItem): Resource<Boolean> {
        return try {
            withContext(Dispatchers.IO) {
                favouriteDao.delete(productsItem)
                Resource.success(data = true)
            }
        } catch (cause: Throwable) {
            getResourceFromThrowable(cause)
        }
    }

}