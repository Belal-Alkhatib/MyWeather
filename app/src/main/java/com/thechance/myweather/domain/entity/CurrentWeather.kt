package com.thechance.myweather.domain.entity

data class CurrentWeather(
    val isDay: Boolean,
    val cityName: String,
    val temperature: WeatherValue<Double>,
    val feelsLike: WeatherValue<Double>,
    val weatherCode: Int,
    val humidity: WeatherValue<Int>,
    val rain: WeatherValue<Double>,
    val uvIndex: WeatherValue<Double>,
    val pressure: WeatherValue<Double>,
    val windSpeed: WeatherValue<Double>
)
