package com.thechance.myweather.data.dataSource

import com.thechance.myweather.data.repository.dataSource.WeatherDataSource
import com.thechance.myweather.data.response.weather.WeatherResponse
import com.thechance.myweather.data.utils.safeApiCall
import com.thechance.myweather.domain.entity.Location
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class OpenMeteoApiWeatherDataSource(
    private val client: HttpClient,
    private val baseUrl: String
) : WeatherDataSource {
    override suspend fun getWeatherByLocation(location: Location): WeatherResponse {
        val response = safeApiCall {
            client.get(baseUrl) {
                parameter(LATITUDE, "${location.latitude}")
                parameter(LONGITUDE, "${location.longitude}")
                parameter(DAILY, dailyFields)
                parameter(HOURLY, hourlyFields)
                parameter(CURRENT, currentFields)
                parameter(FORECAST_HOURS, FORECAST_HOURS_12)
            }
        }

        return response.body()
    }

    private companion object {
        const val DAILY = "daily"
        const val HOURLY = "hourly"
        const val CURRENT = "current"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
        const val FORECAST_HOURS = "forecast_hours"


        const val WEATHER_CODE = "weather_code"
        const val IS_DAY = "is_day"
        const val TEMPERATURE = "temperature_2m"

        const val MAX_TEMPERATURE = "temperature_2m_max"
        const val MIN_TEMPERATURE = "temperature_2m_min"
        const val APPARENT_TEMPERATURE = "apparent_temperature"

        const val UV_INDEX = "uv_index_max"
        const val RELATIVE_HUMIDITY = "relative_humidity_2m"
        const val WIND_SPEED = "wind_speed_10m"
        const val RAIN = "rain"
        const val PRESSURE = "pressure_msl"

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

        private fun List<String>.asCsv(): String = joinToString(",")
    }
}