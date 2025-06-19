package com.thechance.myweather.domain.entity

data class WeatherValue<V>(val value: V, val unit: WeatherUnit)

enum class WeatherUnit(val symbol: String) {
    Celsius("°C"),
    Percent("%"),
    KmPerHour(" km/h"),
    Hpa(" hPa"),
    NoUnit("");
    companion object {
        fun fromSymbol(symbol: String): WeatherUnit {
            return WeatherUnit.entries.firstOrNull { it.symbol.contains(symbol, ignoreCase = true) }  ?: NoUnit
        }
    }
}