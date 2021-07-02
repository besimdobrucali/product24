package com.dobrucali.product24.data.error

import com.dobrucali.product24.utils.Resource

fun <T> getResourceFromThrowable(cause: Throwable): Resource<T> {
    return Resource.error(
        Product24Exception(
            title = cause.localizedMessage ?: cause.toString(),
            message = cause.message ?: cause.toString(),
            code = 9999
        )
    )
}