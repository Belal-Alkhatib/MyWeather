package com.thechance.myweather.domain.entity

import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.TodayWeatherItemUiState
import java.time.LocalTime

data class HourlyForecast(
    val time: LocalTime,
    val temperature: WeatherValue<Double>,
    val weatherCode: Int

)

fun HourlyForecast.toTodayWeatherItemUiState(): TodayWeatherItemUiState {
    return TodayWeatherItemUiState(
        imageCode = this.weatherCode,
        temperature = WeatherValue(this.temperature.value.toInt(), this.temperature.unit),
        hour = time.toString()
    )
}
