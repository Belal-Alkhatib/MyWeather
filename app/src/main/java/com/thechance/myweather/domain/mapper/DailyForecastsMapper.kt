package com.thechance.myweather.domain.mapper

import com.thechance.myweather.data.response.weather.dilayWeather.DailyWeatherResponse
import com.thechance.myweather.data.response.weather.dilayWeather.DailyWeatherUnitsDto
import com.thechance.myweather.data.utils.toLocalDate
import com.thechance.myweather.domain.entity.DailyForecast
import com.thechance.myweather.domain.entity.WeatherValue

fun DailyWeatherResponse.toDailyForecasts(units: DailyWeatherUnitsDto?): List<DailyForecast> {
    val temperatureUnit = units?.maxTemperature.orEmpty()

    return this.times?.mapIndexedNotNull { index, date ->
        val date = date?.toLocalDate() ?: return@mapIndexedNotNull null
        val weatherCodeValue = this.weatherCodes?.getOrNull(index) ?: return@mapIndexedNotNull null
        val highTemp = this.maxTemperatures?.getOrNull(index) ?: return@mapIndexedNotNull null
        val lowTemp = this.minTemperatures?.getOrNull(index) ?: return@mapIndexedNotNull null

        DailyForecast(
            date = date,
            weatherCode = weatherCodeValue,
            highTemperature = WeatherValue(highTemp, temperatureUnit),
            lowTemperature = WeatherValue(lowTemp, temperatureUnit)
        )
    } ?: emptyList()
}