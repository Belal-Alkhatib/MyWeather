package com.thechance.myweather.ui.screen.weatherOverview.util

import androidx.annotation.StringRes
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeatherTitle
import com.thechance.myweather.R

@StringRes
fun getWeatherTitleResourceByWeatherTitle(title: WeatherTitle): Int {
    return when(title){
        WeatherTitle.WIND -> R.string.wind
        WeatherTitle.HUMIDITY -> R.string.humidity
        WeatherTitle.RAIN -> R.string.rain
        WeatherTitle.UV_INDEX -> R.string.uv_index
        WeatherTitle.PRESSURE -> R.string.pressure
        WeatherTitle.FEELS_LIKE -> R.string.feels_like
        WeatherTitle.UNKNOWN -> R.string.empty
    }
}
