package com.dobrucali.product24.data.repository

import androidx.lifecycle.LiveData
import com.dobrucali.product24.data.FavouriteDao
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.data.entity.Status
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
                addUserToDb(productsItem)
                Resource(Status.SUCCESS, data = true, error = null, exception = null)
            }
        } catch (cause: Throwable) {
            getResourceFromThrowable(cause)
        }
    }

    private fun addUserToDb(productsItem: ProductsItem) {
        return favouriteDao.insertFavourite(productsItem)
    }

    suspend fun removeFavourite(productsItem: ProductsItem): Resource<Boolean> {
        return try {
            withContext(Dispatchers.IO) {
                favouriteDao.delete(productsItem)
                Resource(Status.SUCCESS, data = true, error = null, exception = null)
            }
        } catch (cause: Throwable) {
            getResourceFromThrowable(cause)
        }
    }

}