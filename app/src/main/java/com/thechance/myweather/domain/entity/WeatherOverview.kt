package com.thechance.myweather.domain.entity

import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.CurrentWeatherInfoUiState
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeatherDetailItemUiState
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeatherOverviewUiState
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeatherTitle

data class WeatherOverview(
    val current: CurrentWeather,
    val hourly: List<HourlyForecast>,
    val daily: List<DailyForecast>
)

fun WeatherOverview.toWeatherOverviewUiState(): WeatherOverviewUiState {
    val currentHighTemperature = this.daily.firstOrNull()?.highTemperature ?: WeatherValue(0.0, WeatherUnit.Celsius)
    val currentLowTemperature = this.daily.firstOrNull()?.lowTemperature ?: WeatherValue(0.0, WeatherUnit.Celsius)
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



