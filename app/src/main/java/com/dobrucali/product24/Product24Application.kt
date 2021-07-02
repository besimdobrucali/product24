package com.dobrucali.product24

import android.app.Application
import com.dobrucali.product24.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Product24Application: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // declare used Android context
            androidContext(this@Product24Application)
            // declare modules
            modules(appModule)
        }

    }
}