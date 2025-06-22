package com.thechance.myweather.data.response.weather.currentWeather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    @SerialName("apparent_temperature")
    val apparentTemperature: Double? = null,
    @SerialName("interval")
    val interval: Int? = null,
    @SerialName("is_day")
    val isDay: Int? = null,
    @SerialName("pressure_msl")
    val pressure: Double? = null,
    @SerialName("rain")
    val rain: Double? = null,
    @SerialName("relative_humidity_2m")
    val relativeHumidity: Int? = null,
    @SerialName("temperature_2m")
    val temperature: Double? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("weather_code")
    val weatherCode: Int? = null,
    @SerialName("wind_speed_10m")
    val windSpeed: Double? = null
)