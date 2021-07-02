package com.dobrucali.product24.task

import com.dobrucali.product24.data.entity.ProductResponse
import com.dobrucali.product24.data.repository.ProductRepository
import com.dobrucali.product24.utils.Resource

class ProductTask(
    val productRepository: ProductRepository,
)  {

    suspend fun getProducts(): Resource<ProductResponse> {
        return productRepository.getProducts()
    }

}