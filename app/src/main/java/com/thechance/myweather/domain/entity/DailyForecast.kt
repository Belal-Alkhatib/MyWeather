package com.thechance.myweather.domain.entity

import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeekWeatherItemUiState
import java.time.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val weatherCode: Int,
    val highTemperature: WeatherValue<Double>,
    val lowTemperature: WeatherValue<Double>,
)

fun DailyForecast.toWeekWeatherItemUiState(): WeekWeatherItemUiState {
    return WeekWeatherItemUiState(
        dayOfWeek = this.date.dayOfWeek.toString(),
        imageCode = this.weatherCode,
        highTemperature = WeatherValue(value = this.highTemperature.value.toInt(), this.highTemperature.unit),
        lowTemperature = WeatherValue(value = this.lowTemperature.value.toInt(), this.lowTemperature.unit)
    )
}

