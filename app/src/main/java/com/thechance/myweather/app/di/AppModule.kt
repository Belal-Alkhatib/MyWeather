package com.thechance.myweather.app.di

import android.location.Location
import android.system.Os.bind
import com.thechance.myweather.data.dataSource.LocationDataSource
import com.thechance.myweather.data.dataSource.LocationServiceDataSource
import com.thechance.myweather.data.dataSource.OpenMeteoApiWeatherDataSource
import com.thechance.myweather.data.dataSource.WeatherDataSource
import com.thechance.myweather.data.repository.RepositoryImpl
import com.thechance.myweather.domain.repository.Repository
import com.thechance.myweather.domain.usecase.GetWeatherUseCase
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module {

    //network
    single<HttpClient> { HttpClient(CIO) }
    single<Json> { Json { ignoreUnknownKeys = true; isLenient = true } }

    //data source
    singleOf(::LocationServiceDataSource){ bind<LocationDataSource>()}
    singleOf(::OpenMeteoApiWeatherDataSource){ bind<WeatherDataSource>()}

    //repository
    singleOf(::RepositoryImpl) { bind<Repository>() }

    //use case
    single { GetWeatherUseCase(get()) }



}

