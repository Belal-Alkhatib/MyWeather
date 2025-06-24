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
            temperature = WeatherValue(value = this.current.temperature.value.toString(), this.current.temperature.unit),
            weatherType = this.current.weatherType,
            highTemperature = WeatherValue(value = currentHighTemperature.value.toString(), currentHighTemperature.unit),
            lowTemperature = WeatherValue(value = currentLowTemperature.value.toString(), currentLowTemperature.unit),
            description = this.current.weatherType
        ),
        weatherDetails = this.current.toListOfWeatherDetailItemUiState(),
        todayWeather = this.hourly.map { it.toTodayWeatherItemUiState() },
        weeklyWeather = this.daily.map { it.toWeekWeatherItemUiState() },
    )
}