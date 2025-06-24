package com.thechance.myweather.ui.mapper

import com.thechance.myweather.domain.entity.HourlyForecast
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.screen.weatherOverview.TodayWeatherItemUiState

fun HourlyForecast.toTodayWeatherItemUiState(): TodayWeatherItemUiState {
    return TodayWeatherItemUiState(
        weatherType = this.weatherType,
        temperature = WeatherValue(this.temperature.value.toInt(), this.temperature.unit),
        hour = time.toString()
    )
}