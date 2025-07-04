package com.thechance.myweather.data.response.weather.hourlyWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherUnitsDto(
    @SerialName("temperature_2m")
    val temperature: String? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("weather_code")
    val weatherCode: String? = null
)