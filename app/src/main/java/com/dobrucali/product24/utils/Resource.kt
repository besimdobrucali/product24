package com.dobrucali.product24.utils

import com.dobrucali.product24.data.entity.Status
import com.dobrucali.product24.data.error.Product24Exception

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val error: Product24Exception?,
    val exception: Throwable?
) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, error = null, exception = null)
        }

        fun <T> error(error: Product24Exception, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, error, exception = null)
        }

        fun <T> exception(exception: Throwable?, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, error = null, exception)
        }

    }

}

internal fun Resource<Any>.isSuccess(): Boolean {
    return this.status == Status.SUCCESS
}