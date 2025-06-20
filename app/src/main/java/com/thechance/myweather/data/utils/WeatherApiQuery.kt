package com.thechance.myweather.data.utils

object WeatherApiParams {
    const val DAILY = "daily"
    const val HOURLY = "hourly"
    const val CURRENT = "current"
    const val LATITUDE = "latitude"
    const val LONGITUDE = "longitude"
    const val FORECAST_HOURS = "forecast_hours"
}

object WeatherFields {
    private const val WEATHER_CODE = "weather_code"
    private const val IS_DAY = "is_day"
    private const val TEMPERATURE = "temperature_2m"

    private const val MAX_TEMPERATURE = "temperature_2m_max"
    private const val MIN_TEMPERATURE = "temperature_2m_min"
    private const val APPARENT_TEMPERATURE = "apparent_temperature"

    private const val UV_INDEX = "uv_index_max"
    private const val RELATIVE_HUMIDITY = "relative_humidity_2m"
    private const val WIND_SPEED = "wind_speed_10m"
    private const val RAIN = "rain"
    private const val PRESSURE = "pressure_msl"

    const val FORECAST_HOURS_12 = "12"

    val dailyFields = listOf(UV_INDEX, WEATHER_CODE, MAX_TEMPERATURE, MIN_TEMPERATURE).asCsv()

    val hourlyFields = listOf(TEMPERATURE, WEATHER_CODE).asCsv()

    val currentFields = listOf(
        IS_DAY,
        TEMPERATURE,
        WEATHER_CODE,
        RELATIVE_HUMIDITY,
        WIND_SPEED,
        RAIN,
        APPARENT_TEMPERATURE,
        PRESSURE
    ).asCsv()
}

fun List<String>.asCsv(): String = joinToString(",")