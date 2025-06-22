package com.thechance.myweather.data.repository.dataSource

import com.thechance.myweather.data.response.weather.WeatherResponse
import com.thechance.myweather.domain.entity.Location

interface WeatherDataSource {
    suspend fun getWeatherByLocation(location: Location): WeatherResponse
}