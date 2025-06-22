package com.thechance.myweather.ui.mapper

import com.thechance.myweather.domain.entity.DailyForecast
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.screen.weatherOverview.WeekWeatherItemUiState

fun DailyForecast.toWeekWeatherItemUiState(): WeekWeatherItemUiState {
    return WeekWeatherItemUiState(
        dayOfWeek = this.date.dayOfWeek.toString(),
        imageCode = this.weatherCode,
        highTemperature = WeatherValue(value = this.highTemperature.value.toInt(), this.highTemperature.unit),
        lowTemperature = WeatherValue(value = this.lowTemperature.value.toInt(), this.lowTemperature.unit)
    )
}