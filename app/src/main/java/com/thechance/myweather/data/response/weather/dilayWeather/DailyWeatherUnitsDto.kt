package com.thechance.myweather.data.response.weather.dilayWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherUnitsDto(
    @SerialName("temperature_2m_max")
    val maxTemperature: String? = null,
    @SerialName("temperature_2m_min")
    val minTemperature: String? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("uv_index_max")
    val maxUvIndex: String? = null,
    @SerialName("weather_code")
    val weatherCode: String? = null
)