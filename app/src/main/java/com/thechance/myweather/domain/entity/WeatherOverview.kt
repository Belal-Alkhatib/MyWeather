package com.thechance.myweather.domain.entity

data class WeatherOverview(
    val current: CurrentWeather,
    val hourly: List<HourlyForecast>,
    val daily: List<DailyForecast>
)