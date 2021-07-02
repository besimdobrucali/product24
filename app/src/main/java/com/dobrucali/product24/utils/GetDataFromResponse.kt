package com.dobrucali.product24.utils

import com.dobrucali.product24.data.error.Product24Exception
import retrofit2.Response

inline fun <reified T> getDataFromResponse(response: Response<T>): Resource<T> {
    return if (response.isSuccessful && response.body() is T) {
        val data = response.body() as T
        Resource.success(data)
    } else {
        try {
            Resource.error(
                Product24Exception(
                    title = "Error",
                    message = response.errorBody()!!.string(),
                    code = Constants.API_REQUEST_ERROR
                )
            )
        } catch (cause: Throwable) {
            Resource.error(
                Product24Exception(
                    title = "${response.code()}",
                    message = response.message(),
                    code = Constants.API_REQUEST_ERROR
                )
            )
        }
    }
}