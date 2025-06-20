package com.thechance.myweather.app.di

import com.thechance.myweather.data.dataSource.LocationByIpDataSource
import com.thechance.myweather.data.dataSource.OpenMeteoApiWeatherDataSource
import com.thechance.myweather.data.repository.dataSource.LocationDataSource
import com.thechance.myweather.data.repository.dataSource.WeatherDataSource
import com.thechance.myweather.ui.resource.DefaultStringsResource
import com.thechance.myweather.ui.screen.base.StringsResource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataSourceModule = module {

    single<LocationDataSource> {
            LocationByIpDataSource(
            client = get(),
            json = get(),
            baseUrl = get<String>(AppConstants.Qualifiers.LocationByIpApiBaseUrl)
        )
    }

    single<WeatherDataSource> {
        OpenMeteoApiWeatherDataSource(
            client = get(),
            json = get(),
            baseUrl = get<String>(AppConstants.Qualifiers.WeatherApiBaseUrl)
        )
    }

    single<StringsResource> { DefaultStringsResource(androidContext()) }

}