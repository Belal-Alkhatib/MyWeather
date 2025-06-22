package com.thechance.myweather.data.response.weather.hourlyWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherResponse(
    @SerialName("temperature_2m")
    val temperatures: List<Double?>? = null,
    @SerialName("time")
    val times: List<String?>? = null,
    @SerialName("weather_code")
    val weatherCode: List<Int?>? = null
)