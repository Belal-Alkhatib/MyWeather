package com.thechance.myweather.domain.mapper

import com.thechance.myweather.data.response.weather.WeatherResponse
import com.thechance.myweather.domain.entity.CurrentWeather
import com.thechance.myweather.domain.entity.WeatherOverview
import com.thechance.myweather.domain.entity.WeatherValue

fun WeatherResponse.toWeatherOverview(cityName: String): WeatherOverview {
    val defaultCurrentWeather = CurrentWeather(
        isDay = false,
        cityName = cityName,
        temperature = WeatherValue(0.0, ""),
        feelsLike = WeatherValue(0.0, ""),
        weatherCode = 0,
        humidity = WeatherValue(0, ""),
        rain = WeatherValue(0.0, ""),
        uvIndex = WeatherValue(0.0, ""),
        pressure = WeatherValue(0.0, ""),
        windSpeed = WeatherValue(0.0, "")
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