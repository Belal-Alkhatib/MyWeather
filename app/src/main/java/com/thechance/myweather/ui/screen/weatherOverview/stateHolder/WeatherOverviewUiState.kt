package com.thechance.myweather.ui.screen.weatherOverview.stateHolder

import com.thechance.myweather.domain.entity.WeatherUnit
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.screen.base.BaseUiState

data class WeatherOverviewUiState(
    val cityName: String = "",
    val isDay: Boolean = false,
    val currentWeatherInfoUiState: CurrentWeatherInfoUiState = CurrentWeatherInfoUiState(),
    val weatherDetails: List<WeatherDetailItemUiState> = emptyList(),
    val todayWeather: List<TodayWeatherItemUiState> = emptyList(),
    val weeklyWeather: List<WeekWeatherItemUiState> = emptyList(),
    val baseUiState: BaseUiState = BaseUiState()
)

private val celsiusDefaultWeatherValue = WeatherValue(value = 0, WeatherUnit.Celsius)

data class CurrentWeatherInfoUiState(
    val temperature: WeatherValue<Int> = celsiusDefaultWeatherValue,
    val description: String = "",
    val highTemperature: WeatherValue<Int> = celsiusDefaultWeatherValue,
    val lowTemperature: WeatherValue<Int> = celsiusDefaultWeatherValue,
    val imageCode: Int = 0,
)


data class WeatherDetailItemUiState(
    val iconResource: Int = 0,
    val title: WeatherTitle = WeatherTitle.UNKNOWN,
    val value: WeatherValue<Int> = WeatherValue(value = 0, WeatherUnit.NoUnit)
)

enum class WeatherTitle() {
    WIND,
    HUMIDITY,
    RAIN,
    UV_INDEX,
    PRESSURE,
    FEELS_LIKE,
    UNKNOWN,
}

data class TodayWeatherItemUiState(
    val imageCode: Int = 0,
    val temperature: WeatherValue<Int> = celsiusDefaultWeatherValue,
    val hour: String = ""
)

data class WeekWeatherItemUiState(
    val dayOfWeek: String = "",
    val imageCode: Int = 0,
    val highTemperature: WeatherValue<Int> = celsiusDefaultWeatherValue,
    val lowTemperature: WeatherValue<Int> = celsiusDefaultWeatherValue
)

