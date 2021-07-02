package com.dobrucali.product24.di.module

import android.content.Context

/**
 * Holds the application Android Context
 */
class ContextModule(
    private val applicationContext: Context
) {
    fun getContext(): Context {
        return applicationContext
    }

}