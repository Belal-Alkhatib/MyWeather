package com.thechance.myweather.data.response.hourlyWeather

import com.thechance.myweather.data.utils.toLocalTime
import com.thechance.myweather.domain.entity.HourlyForecast
import com.thechance.myweather.domain.entity.WeatherUnit
import com.thechance.myweather.domain.entity.WeatherValue
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

fun HourlyWeatherResponse.toHourlyForecasts(units: HourlyWeatherUnitsResponse?): List<HourlyForecast> {
    val temperatureUnit = WeatherUnit.fromSymbol(units?.temperature.orEmpty())

    return times?.mapIndexedNotNull { index, time ->
        val localTime = time?.toLocalTime() ?: return@mapIndexedNotNull null
        val temperature = temperatures?.getOrNull(index) ?: return@mapIndexedNotNull null
        val weatherCode = weatherCode?.getOrNull(index) ?: return@mapIndexedNotNull null

        HourlyForecast(
            time = localTime,
            temperature = WeatherValue(temperature, temperatureUnit),
            weatherCode = weatherCode
        )
    } ?: emptyList()
}