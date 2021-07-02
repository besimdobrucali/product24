package com.dobrucali.product24.viewModels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.task.ProductTask
import com.dobrucali.product24.utils.Constants

class ProductDetailViewModel(
    private val productTask: ProductTask,
) : BaseViewModel() {

    private val _product = MutableLiveData<ProductsItem>()
    val product: LiveData<ProductsItem>
        get() = _product

    private val _favouriteList = MutableLiveData<List<ProductsItem>>()
    val favouriteList: LiveData<List<ProductsItem>>
        get() = _favouriteList

    fun bindArguments(arguments: Bundle) {
        val product = arguments.getParcelable<ProductsItem>(Constants.PRODUCT_KEY)
        product?.let {
            _product.value = it
        }
    }

    fun onChangeFavouriteOptionClicked(){

    }

    fun isFavourite(): Boolean {
        return favouriteList.value?.contains(product.value) ?: false
    }

}