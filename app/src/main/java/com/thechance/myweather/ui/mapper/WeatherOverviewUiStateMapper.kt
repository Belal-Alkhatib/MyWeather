package com.thechance.myweather.ui.mapper

import com.thechance.myweather.domain.entity.WeatherOverview
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.screen.weatherOverview.CurrentWeatherInfoUiState
import com.thechance.myweather.ui.screen.weatherOverview.WeatherOverviewUiState

fun WeatherOverview.toWeatherOverviewUiState(): WeatherOverviewUiState {
    val currentHighTemperature = this.daily.firstOrNull()?.highTemperature ?: WeatherValue(0.0, "")
    val currentLowTemperature = this.daily.firstOrNull()?.lowTemperature ?: WeatherValue(0.0, "")
    return WeatherOverviewUiState(
        cityName = this.current.cityName,
        isDay = this.current.isDay,
        currentWeatherInfoUiState = CurrentWeatherInfoUiState(
            temperature = WeatherValue(value = this.current.temperature.value.toInt(), this.current.temperature.unit),
            imageCode = this.current.weatherCode,
            highTemperature = WeatherValue(value = currentHighTemperature.value.toInt(), currentHighTemperature.unit),
            lowTemperature = WeatherValue(value = currentLowTemperature.value.toInt(), currentLowTemperature.unit),
        ),
        weatherDetails = this.current.toListOfWeatherDetailItemUiState(),
        todayWeather = this.hourly.map { it.toTodayWeatherItemUiState() },
        weeklyWeather = this.daily.map { it.toWeekWeatherItemUiState() },
    )
}