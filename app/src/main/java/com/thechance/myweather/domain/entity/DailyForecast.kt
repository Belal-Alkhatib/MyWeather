package com.thechance.myweather.domain.entity

import kotlinx.datetime.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val weatherCode: Int,
    val highTemperature: WeatherValue<Double>,
    val lowTemperature: WeatherValue<Double>,
)

