package com.thechance.myweather.data.response.dilayWeather

import com.thechance.myweather.data.utils.toLocalDate
import com.thechance.myweather.domain.entity.DailyForecast
import com.thechance.myweather.domain.entity.WeatherUnit
import com.thechance.myweather.domain.entity.WeatherValue
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

fun DailyWeatherResponse.toDailyForecasts(units: DailyWeatherUnitsResponse?): List<DailyForecast> {
    val temperatureUnit = WeatherUnit.fromSymbol(units?.maxTemperature.orEmpty())

    return this.times?.mapIndexedNotNull { index, date ->
        val date = date?.toLocalDate() ?: return@mapIndexedNotNull null
        val weatherCodeValue = this.weatherCodes?.getOrNull(index) ?: return@mapIndexedNotNull null
        val highTemp = this.maxTemperatures?.getOrNull(index) ?: return@mapIndexedNotNull null
        val lowTemp = this.minTemperatures?.getOrNull(index) ?: return@mapIndexedNotNull null

        DailyForecast(
            date = date,
            weatherCode = weatherCodeValue,
            highTemperature = WeatherValue(highTemp, temperatureUnit),
            lowTemperature = WeatherValue(lowTemp, temperatureUnit)
        )
    } ?: emptyList()
}