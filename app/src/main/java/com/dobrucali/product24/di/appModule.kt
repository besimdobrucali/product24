package com.dobrucali.product24.di

import com.dobrucali.product24.data.repository.ProductRepository
import com.dobrucali.product24.di.module.ContextModule
import com.dobrucali.product24.di.module.RetrofitClient
import com.dobrucali.product24.task.ProductTask
import com.dobrucali.product24.viewModels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Singletons
    single { ContextModule(androidContext()) }

    // Retrofit
    single { RetrofitClient() }
    factory { get<RetrofitClient>().productApi() }

    // Repositories
    factory { ProductRepository(get()) }

    // Use Cases
    factory { ProductTask(get()) }

    // View Models
    viewModel { MainViewModel(get()) }

}