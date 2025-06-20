package com.thechance.myweather.app.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single<HttpClient> { HttpClient(CIO) }
    single<Json> { Json { ignoreUnknownKeys = true; isLenient = true } }

    single<String>(qualifier = AppConstants.Qualifiers.WeatherApiBaseUrl) { AppConstants.WEATHER_API_BASE_URL }
    single<String>(qualifier = AppConstants.Qualifiers.LocationByIpApiBaseUrl) { AppConstants.LOCATION_BY_IP_API_BASE_URL }

}