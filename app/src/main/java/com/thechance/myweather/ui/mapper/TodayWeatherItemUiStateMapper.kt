package com.thechance.myweather.ui.mapper

import com.thechance.myweather.data.utils.toHourString
import com.thechance.myweather.domain.entity.HourlyForecast
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.screen.weatherOverview.TodayWeatherItemUiState

fun HourlyForecast.toTodayWeatherItemUiState(): TodayWeatherItemUiState {
    return TodayWeatherItemUiState(
        imageCode = this.weatherCode,
        temperature = WeatherValue(this.temperature.value.toInt(), this.temperature.unit),
        hour = time.toHourString()
    )
}