package com.thechance.myweather.ui.screen.mapper

import androidx.annotation.DrawableRes
import com.thechance.myweather.ui.screen.weatherOverview.WeatherTitle
import com.thechance.myweather.R

@DrawableRes
fun getWeatherDetailIconResByTitle(title: WeatherTitle): Int {
    return when (title) {
        WeatherTitle.WIND -> R.drawable.icon_fast_wind
        WeatherTitle.HUMIDITY -> R.drawable.icon_humidity
        WeatherTitle.RAIN -> R.drawable.icon_rain
        WeatherTitle.UV_INDEX -> R.drawable.icon_uv
        WeatherTitle.PRESSURE -> R.drawable.icon_arrow_down_on_line
        WeatherTitle.FEELS_LIKE -> R.drawable.icon_temperature
        WeatherTitle.UNKNOWN -> R.drawable.icon_temperature
    }
}