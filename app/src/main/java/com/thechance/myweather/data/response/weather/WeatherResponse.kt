package com.thechance.myweather.data.response.weather

import com.thechance.myweather.data.response.weather.currentWeather.CurrentWeatherResponse
import com.thechance.myweather.data.response.weather.currentWeather.CurrentWeatherUnitsDto
import com.thechance.myweather.data.response.weather.dilayWeather.DailyWeatherResponse
import com.thechance.myweather.data.response.weather.dilayWeather.DailyWeatherUnitsDto
import com.thechance.myweather.data.response.weather.hourlyWeather.HourlyWeatherResponse
import com.thechance.myweather.data.response.weather.hourlyWeather.HourlyWeatherUnitsDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("current")
    val currentWeatherResponse: CurrentWeatherResponse? = null,
    @SerialName("current_units")
    val currentWeatherUnitsResponse: CurrentWeatherUnitsDto? = null,
    @SerialName("daily")
    val dailyWeatherResponse: DailyWeatherResponse? = null,
    @SerialName("daily_units")
    val dailyWeatherUnitsResponse: DailyWeatherUnitsDto? = null,
    @SerialName("elevation")
    val elevation: Double? = null,
    @SerialName("generationtime_ms")
    val generationTimeInMs: Double? = null,
    @SerialName("hourly")
    val hourlyWeatherResponse: HourlyWeatherResponse? = null,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyWeatherUnitsDto? = null,
    @SerialName("latitude")
    val latitude: Double? = null,
    @SerialName("longitude")
    val longitude: Double? = null,
    @SerialName("timezone")
    val timezone: String? = null,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String? = null,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int? = null
)