package com.thechance.myweather.domain.repository

import com.thechance.myweather.domain.entity.Location
import com.thechance.myweather.domain.entity.WeatherOverview

interface WeatherRepository {
    suspend fun getWeatherOverviewByLocation(location: Location): WeatherOverview
}