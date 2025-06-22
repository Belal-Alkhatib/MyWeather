package com.thechance.myweather.ui.mapper

import com.thechance.myweather.domain.entity.CurrentWeather
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.screen.weatherOverview.WeatherDetailItemUiState
import com.thechance.myweather.ui.screen.weatherOverview.WeatherTitle

fun CurrentWeather.toListOfWeatherDetailItemUiState(): List<WeatherDetailItemUiState> {
    val wind = WeatherDetailItemUiState(
        title = WeatherTitle.WIND,
        value = WeatherValue(value = this.windSpeed.value.toInt(), this.windSpeed.unit)
    )
    val humidity = WeatherDetailItemUiState(
        title = WeatherTitle.HUMIDITY,
        value = WeatherValue(value = this.humidity.value.toInt(), this.humidity.unit)
    )
    val rain = WeatherDetailItemUiState(
        title = WeatherTitle.RAIN,
        value = WeatherValue(value = this.rain.value.toInt(), this.rain.unit)
    )
    val uvIndex = WeatherDetailItemUiState(
        title = WeatherTitle.UV_INDEX,
        value = WeatherValue(value = this.uvIndex.value.toInt(), this.uvIndex.unit)
    )
    val pressure = WeatherDetailItemUiState(
        title = WeatherTitle.PRESSURE,
        value = WeatherValue(value = this.pressure.value.toInt(), this.pressure.unit)
    )
    val feelsLike = WeatherDetailItemUiState(
        title = WeatherTitle.FEELS_LIKE,
        value = WeatherValue(value = this.feelsLike.value.toInt(), this.feelsLike.unit)
    )
    return listOf(wind, humidity, rain, uvIndex, pressure, feelsLike)
}

