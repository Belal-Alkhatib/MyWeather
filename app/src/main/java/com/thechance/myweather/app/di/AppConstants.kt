package com.thechance.myweather.app.di

import org.koin.core.qualifier.named

object AppConstants {
    const val WEATHER_API_BASE_URL = "https://api.open-meteo.com/v1/forecast?"
    const val LOCATION_BY_IP_API_BASE_URL = "http://ip-api.com/json"

    object Qualifiers {
        val WeatherApiBaseUrl = named("WeatherApiBaseUrl")
        val LocationByIpApiBaseUrl = named("LocationByIpApiBaseUrl")
    }
}