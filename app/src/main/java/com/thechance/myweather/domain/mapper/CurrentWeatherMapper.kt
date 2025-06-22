package com.thechance.myweather.domain.mapper

import com.thechance.myweather.data.response.weather.currentWeather.CurrentWeatherResponse
import com.thechance.myweather.data.response.weather.currentWeather.CurrentWeatherUnitsDto
import com.thechance.myweather.domain.entity.CurrentWeather
import com.thechance.myweather.domain.entity.WeatherValue

fun CurrentWeatherResponse.toCurrentWeather(
    units: CurrentWeatherUnitsDto?,
    uvIndex: Double,
    cityName: String = ""
): CurrentWeather {
    return CurrentWeather(
        isDay = this.isDay == 1,
        cityName = cityName,
        temperature = WeatherValue(this.temperature ?: 0.0, units?.temperature.orEmpty()),
        feelsLike = WeatherValue(this.apparentTemperature ?: 0.0, units?.apparentTemperature.orEmpty()),
        weatherCode = this.weatherCode ?: 0,
        humidity = WeatherValue(this.relativeHumidity ?: 0, units?.relativeHumidity.orEmpty()),
        rain = WeatherValue(this.rain ?: 0.0, units?.rain.orEmpty()),
        uvIndex = WeatherValue(uvIndex, ""),
        pressure = WeatherValue(this.pressure ?: 0.0, units?.pressure.orEmpty()),
        windSpeed = WeatherValue(this.windSpeed ?: 0.0, units?.windSpeed.orEmpty())
    )
}