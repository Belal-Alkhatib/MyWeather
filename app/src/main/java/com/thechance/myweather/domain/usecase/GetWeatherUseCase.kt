package com.thechance.myweather.domain.usecase

import com.thechance.myweather.domain.entity.WeatherOverview
import com.thechance.myweather.domain.repository.LocationRepository
import com.thechance.myweather.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val locationRepository: LocationRepository,
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(): WeatherOverview {
        val weatherOverview = weatherRepository.getWeatherOverviewByLocation(locationRepository.getCurrentLocation())
        return weatherOverview
    }

}