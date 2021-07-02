package com.dobrucali.product24.viewModels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.dobrucali.product24.data.entity.FilterType
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.data.entity.Status
import com.dobrucali.product24.task.FavouriteTask
import com.dobrucali.product24.utils.Constants
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val favouriteTask: FavouriteTask
) : BaseViewModel() {

    private val _product = MutableLiveData<ProductsItem>()
    val product: LiveData<ProductsItem>
        get() = _product

    private val _favouriteList = favouriteTask.getFavouriteProductList()
    val favouriteList: LiveData<List<ProductsItem>>
        get() = _favouriteList

    private val _isFavourite = MutableLiveData<Boolean>()
    val isFavourite: LiveData<Boolean>
        get() = _isFavourite

    fun setIsFavourite(favouriteList : List<ProductsItem>){
        _isFavourite.value = favouriteList.contains(product.value)
    }

    val isFavouriteFlag = Transformations.map(isFavourite) {
        it ?: false
    }

    fun bindArguments(arguments: Bundle) {
        val product = arguments.getParcelable<ProductsItem>(Constants.PRODUCT_KEY)
        product?.let {
            _product.value = it
        }
    }

    fun onChangeFavouriteOptionClicked() {
        product.value?.let { product ->
            if (isFavouriteFlag.value == true) {
                removeFavourite(product)
            } else {
                addFavourite(product)
            }
        }
    }

    private fun addFavourite(product: ProductsItem) {
        viewModelScope.launch {
            try {
                _status.value = Status.LOADING
                val result = favouriteTask.addFavourite(product)
                _status.value = result.status
                when (result.status) {
                    Status.SUCCESS -> {

                    }
                    Status.ERROR -> {
                        _errorMessage.value = result.error?.message
                    }
                    else -> {}
                }
            } catch (error: Exception) {
                _status.value = Status.ERROR
                _errorMessage.value = error.message
            }
        }
    }

    private fun removeFavourite(product: ProductsItem) {
        viewModelScope.launch {
            try {
                _status.value = Status.LOADING
                val result = favouriteTask.removeFavourite(product)
                _status.value = result.status
                when (result.status) {
                    Status.SUCCESS -> {

                    }
                    Status.ERROR -> {
                        _errorMessage.value = result.error?.message
                    }
                    else -> {}
                }
            } catch (error: Exception) {
                _status.value = Status.ERROR
                _errorMessage.value = error.message
            }
        }
    }
}