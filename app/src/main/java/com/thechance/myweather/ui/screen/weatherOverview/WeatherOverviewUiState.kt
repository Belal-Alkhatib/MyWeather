package com.thechance.myweather.ui.screen.weatherOverview

import com.thechance.myweather.domain.entity.WeatherType
import com.thechance.myweather.domain.entity.WeatherValue

data class WeatherOverviewUiState(
    val cityName: String = "",
    val isDay: Boolean = false,
    val currentWeatherInfoUiState: CurrentWeatherInfoUiState = CurrentWeatherInfoUiState(),
    val weatherDetails: List<WeatherDetailItemUiState> = emptyList(),
    val todayWeather: List<TodayWeatherItemUiState> = emptyList(),
    val weeklyWeather: List<WeekWeatherItemUiState> = emptyList(),
    val isLoading: Boolean = false,
    val errorTypeUiState: ErrorTypeUiState? = null
){
    fun hasError() = errorTypeUiState != null
    fun notLoadingAndHasNotError() = !hasError() && !isLoading
}

data class CurrentWeatherInfoUiState(
    val temperature: WeatherValue<String> = WeatherValue(value = "", ""),
    val description: WeatherType = WeatherType.Unknown,
    val highTemperature: WeatherValue<String> = WeatherValue(value = "", ""),
    val lowTemperature: WeatherValue<String> = WeatherValue(value = "", ""),
    val weatherType: WeatherType = WeatherType.Unknown,
)


data class WeatherDetailItemUiState(
    val iconResource: Int = 0,
    val title: WeatherTitle = WeatherTitle.UNKNOWN,
    val value: WeatherValue<Int> = WeatherValue(value = 0, "")
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
    val weatherType: WeatherType = WeatherType.Unknown,
    val temperature: WeatherValue<Int> = WeatherValue(value = 0, ""),
    val hour: String = ""
)

data class WeekWeatherItemUiState(
    val dayOfWeek: String = "",
    val weatherType: WeatherType = WeatherType.Unknown,
    val highTemperature: WeatherValue<String> = WeatherValue(value = "", ""),
    val lowTemperature: WeatherValue<String> = WeatherValue(value = "", "")
)

enum class ErrorTypeUiState() {
    LOCATION_ACCESS,
    LOCATION_PERMISSION_DENIED,
    UNKNOWN_LAST_LOCATION,
    NO_INTERNET,
    SERVER,
    TIMEOUT,
    UNKNOWN_NETWORK,
    ADDRESS_ACCESS,
}
