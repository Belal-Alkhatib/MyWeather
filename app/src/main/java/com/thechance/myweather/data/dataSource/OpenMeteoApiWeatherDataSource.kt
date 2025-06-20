package com.thechance.myweather.data.dataSource

import android.util.Log
import com.thechance.myweather.data.repository.dataSource.WeatherDataSource
import com.thechance.myweather.data.response.WeatherResponse
import com.thechance.myweather.data.utils.WeatherApiParams
import com.thechance.myweather.data.utils.WeatherFields
import com.thechance.myweather.data.utils.getClassByResponse
import com.thechance.myweather.data.utils.safeApiCall
import com.thechance.myweather.domain.entity.Location
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class OpenMeteoApiWeatherDataSource(
    private val client: HttpClient, private val json: Json, private val baseUrl: String
) : WeatherDataSource {
    override suspend fun getWeatherByLocation(location: Location): WeatherResponse {
        val response = safeApiCall {
            client.get(baseUrl) {
                parameter(WeatherApiParams.LATITUDE, "${location.latitude}")
                parameter(WeatherApiParams.LONGITUDE, "${location.longitude}")
                parameter(WeatherApiParams.DAILY, WeatherFields.dailyFields)
                parameter(WeatherApiParams.HOURLY, WeatherFields.hourlyFields)
                parameter(WeatherApiParams.CURRENT, WeatherFields.currentFields)
                parameter(WeatherApiParams.FORECAST_HOURS, WeatherFields.FORECAST_HOURS_12)
            }
        }

        Log.e("bk", "OpenMeteoApiWeatherDataSource response: ${response.bodyAsText()}")
        return getClassByResponse<WeatherResponse>(response = response, json = json)
    }
}