package com.dobrucali.product24.data.api

import com.dobrucali.product24.data.entity.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("/products-test.json")
    suspend fun getProducts(): Response<ProductResponse>

}