package com.dobrucali.product24.di

import android.app.Application
import androidx.room.Room
import com.dobrucali.product24.data.FavouriteDao
import com.dobrucali.product24.data.repository.FavouriteRepository
import com.dobrucali.product24.data.repository.ProductRepository
import com.dobrucali.product24.database.AppDatabase
import com.dobrucali.product24.di.module.ContextModule
import com.dobrucali.product24.di.module.RetrofitClient
import com.dobrucali.product24.task.FavouriteTask
import com.dobrucali.product24.task.ProductTask
import com.dobrucali.product24.viewModels.MainViewModel
import com.dobrucali.product24.viewModels.ProductDetailViewModel
import org.koin.android.ext.koin.androidApplication
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
    factory { FavouriteRepository(get()) }

    // Use Cases
    factory { ProductTask(get()) }
    factory { FavouriteTask(get()) }

    // View Models
    viewModel { MainViewModel(get(), get()) }
    viewModel { ProductDetailViewModel(get()) }


    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "product_24")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideFavouriteDao(database: AppDatabase): FavouriteDao {
        return database.favouriteDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideFavouriteDao(get()) }

}