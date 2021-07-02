package com.dobrucali.product24.data.repository

import com.dobrucali.product24.data.api.ProductApi
import com.dobrucali.product24.data.entity.ProductResponse
import com.dobrucali.product24.utils.Resource
import com.dobrucali.product24.utils.getDataFromResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(
    private val productApi: ProductApi
) {

    suspend fun getProducts(): Resource<ProductResponse> {
        return withContext(Dispatchers.IO) {
            val responseResult = productApi.getProducts()
            getDataFromResponse(responseResult)
        }
    }
}