package com.thechance.myweather.data.response.weather.dilayWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherResponse(
    @SerialName("temperature_2m_max")
    val maxTemperatures: List<Double?>? = null,
    @SerialName("temperature_2m_min")
    val minTemperatures: List<Double?>? = null,
    @SerialName("time")
    val times: List<String?>? = null,
    @SerialName("uv_index_max")
    val maxUvIndexes: List<Double?>? = null,
    @SerialName("weather_code")
    val weatherCodes: List<Int?>? = null
)