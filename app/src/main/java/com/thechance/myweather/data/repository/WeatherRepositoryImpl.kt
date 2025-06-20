package com.thechance.myweather.data.repository

import com.thechance.myweather.data.repository.dataSource.WeatherDataSource
import com.thechance.myweather.data.response.toWeatherOverview
import com.thechance.myweather.domain.entity.Location
import com.thechance.myweather.domain.entity.WeatherOverview
import com.thechance.myweather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource,
): WeatherRepository {
    override suspend fun getWeatherOverviewByLocation(location: Location): WeatherOverview {
        return weatherDataSource.getWeatherByLocation(location).toWeatherOverview(location.cityName)
    }
}