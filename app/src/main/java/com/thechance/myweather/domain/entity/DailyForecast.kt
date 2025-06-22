package com.thechance.myweather.domain.entity

import java.time.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val weatherCode: Int,
    val highTemperature: WeatherValue<Double>,
    val lowTemperature: WeatherValue<Double>,
)

