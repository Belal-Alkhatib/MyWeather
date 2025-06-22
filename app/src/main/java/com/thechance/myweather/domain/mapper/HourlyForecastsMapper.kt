package com.thechance.myweather.domain.mapper

import com.thechance.myweather.data.response.weather.hourlyWeather.HourlyWeatherResponse
import com.thechance.myweather.data.response.weather.hourlyWeather.HourlyWeatherUnitsDto
import com.thechance.myweather.data.utils.toLocalTime
import com.thechance.myweather.domain.entity.HourlyForecast
import com.thechance.myweather.domain.entity.WeatherValue

fun HourlyWeatherResponse.toHourlyForecasts(units: HourlyWeatherUnitsDto?): List<HourlyForecast> {
    return times?.mapIndexedNotNull { index, time ->
        val localTime = time?.toLocalTime() ?: return@mapIndexedNotNull null
        val temperature = temperatures?.getOrNull(index) ?: return@mapIndexedNotNull null
        val weatherCode = weatherCode?.getOrNull(index) ?: return@mapIndexedNotNull null

        HourlyForecast(
            time = localTime,
            temperature = WeatherValue(temperature, units?.temperature.orEmpty()),
            weatherCode = weatherCode
        )
    } ?: emptyList()
}