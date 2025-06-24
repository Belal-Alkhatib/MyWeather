package com.thechance.myweather.domain.entity

import kotlinx.datetime.LocalTime


data class HourlyForecast(
    val time: LocalTime,
    val temperature: WeatherValue<Double>,
    val weatherType: WeatherType
)