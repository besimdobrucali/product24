package com.dobrucali.product24.viewModels

import androidx.lifecycle.viewModelScope
import com.dobrucali.product24.data.entity.Status
import com.dobrucali.product24.task.ProductTask
import kotlinx.coroutines.launch

class MainViewModel(
    private val productTask: ProductTask
) : BaseViewModel() {

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            try {
                _status.value = Status.LOADING
                val result = productTask.getProducts()
                _status.value = result.status
                when (result.status) {
                    Status.SUCCESS -> {
                        result.data?.let { response ->
                            val a = response
                        }
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
