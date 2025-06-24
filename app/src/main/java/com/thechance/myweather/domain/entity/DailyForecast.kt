package com.thechance.myweather.domain.entity

import kotlinx.datetime.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val weatherType: WeatherType,
    val highTemperature: WeatherValue<Double>,
    val lowTemperature: WeatherValue<Double>,
)

