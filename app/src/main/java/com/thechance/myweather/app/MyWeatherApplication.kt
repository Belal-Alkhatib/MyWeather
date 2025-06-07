package com.thechance.myweather.app

import android.app.Application
import com.thechance.myweather.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

import org.koin.core.context.GlobalContext.startKoin

class MyWeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MyWeatherApplication)
            modules(appModule)
        }
    }
}