package com.dobrucali.product24.task

import androidx.lifecycle.LiveData
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.data.repository.FavouriteRepository
import com.dobrucali.product24.utils.Resource

class FavouriteTask(
    val favouriteRepository: FavouriteRepository
) {

    fun getFavouriteProductList(): LiveData<List<ProductsItem>> = favouriteRepository.getFavouriteProductList()

    suspend fun addFavourite(productsItem: ProductsItem): Resource<Boolean> {
        return favouriteRepository.addFavourite(productsItem)
    }

    suspend fun removeFavourite(productsItem: ProductsItem): Resource<Boolean> {
        return favouriteRepository.removeFavourite(productsItem)
    }

}