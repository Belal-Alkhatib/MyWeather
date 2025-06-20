package com.thechance.myweather.app

import android.app.Application
import com.thechance.myweather.app.di.dataSourceModule
import com.thechance.myweather.app.di.networkModule
import com.thechance.myweather.app.di.repositoryModule
import com.thechance.myweather.app.di.useCaseModule
import com.thechance.myweather.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

import org.koin.core.context.GlobalContext.startKoin

class MyWeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MyWeatherApplication)
            modules(networkModule, dataSourceModule, repositoryModule, useCaseModule,
                viewModelModule
            )
        }
    }
}