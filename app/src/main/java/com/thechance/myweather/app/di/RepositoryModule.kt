package com.thechance.myweather.app.di

import com.thechance.myweather.data.repository.LocationRepositoryImpl
import com.thechance.myweather.data.repository.WeatherRepositoryImpl
import com.thechance.myweather.domain.repository.LocationRepository
import com.thechance.myweather.domain.repository.WeatherRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::LocationRepositoryImpl) { bind<LocationRepository>() }
    singleOf(::WeatherRepositoryImpl) { bind<WeatherRepository>() }
}