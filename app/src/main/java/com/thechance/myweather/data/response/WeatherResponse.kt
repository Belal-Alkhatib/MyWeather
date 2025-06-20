package com.thechance.myweather.data.response

import com.thechance.myweather.data.response.currentWeather.CurrentWeatherResponse
import com.thechance.myweather.data.response.currentWeather.CurrentWeatherUnitsResponse
import com.thechance.myweather.data.response.currentWeather.toCurrentWeather
import com.thechance.myweather.data.response.dilayWeather.DailyWeatherUnitsResponse
import com.thechance.myweather.data.response.dilayWeather.DailyWeatherResponse
import com.thechance.myweather.data.response.dilayWeather.toDailyForecasts
import com.thechance.myweather.data.response.hourlyWeather.HourlyWeatherResponse
import com.thechance.myweather.data.response.hourlyWeather.HourlyWeatherUnitsResponse
import com.thechance.myweather.data.response.hourlyWeather.toHourlyForecasts
import com.thechance.myweather.domain.entity.CurrentWeather
import com.thechance.myweather.domain.entity.WeatherOverview
import com.thechance.myweather.domain.entity.WeatherUnit
import com.thechance.myweather.domain.entity.WeatherValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("current")
    val currentWeatherResponse: CurrentWeatherResponse? = null,
    @SerialName("current_units")
    val currentWeatherUnitsResponse: CurrentWeatherUnitsResponse? = null,
    @SerialName("daily")
    val dailyWeatherResponse: DailyWeatherResponse? = null,
    @SerialName("daily_units")
    val dailyWeatherUnitsResponse: DailyWeatherUnitsResponse? = null,
    @SerialName("elevation")
    val elevation: Double? = null,
    @SerialName("generationtime_ms")
    val generationTimeInMs: Double? = null,
    @SerialName("hourly")
    val hourlyWeatherResponse: HourlyWeatherResponse? = null,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyWeatherUnitsResponse? = null,
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

fun WeatherResponse.toWeatherOverview(cityName: String): WeatherOverview {
    val defaultCurrentWeather = CurrentWeather(
        isDay = false,
        cityName = "",
        temperature = WeatherValue(0.0, WeatherUnit.Celsius),
        feelsLike = WeatherValue(0.0, WeatherUnit.Celsius),
        weatherCode = 0,
        humidity = WeatherValue(0, WeatherUnit.Percent),
        rain = WeatherValue(0.0, WeatherUnit.Percent),
        uvIndex = WeatherValue(0.0, WeatherUnit.NoUnit),
        pressure = WeatherValue(0.0, WeatherUnit.Hpa),
        windSpeed = WeatherValue(0.0, WeatherUnit.KmPerHour)
    )
    return WeatherOverview(
        current = this.currentWeatherResponse?.toCurrentWeather(
            units = this.currentWeatherUnitsResponse,
            uvIndex = this.dailyWeatherResponse?.maxUvIndexes?.firstOrNull() ?: 0.0,
            cityName = cityName
        ) ?: defaultCurrentWeather,
        hourly = this.hourlyWeatherResponse?.toHourlyForecasts(this.hourlyUnits) ?: emptyList() ,
        daily = this.dailyWeatherResponse?.toDailyForecasts(this.dailyWeatherUnitsResponse) ?: emptyList()
    )
}


