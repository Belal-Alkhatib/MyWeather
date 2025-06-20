package com.thechance.myweather.data.dataSource

import com.thechance.myweather.data.repository.dataSource.LocationDataSource
import com.thechance.myweather.data.response.LocationResponse
import com.thechance.myweather.data.utils.getClassByResponse
import com.thechance.myweather.data.utils.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

class LocationByIpDataSource(
    private val client: HttpClient,
    private val json: Json,
    private val baseUrl: String,
) : LocationDataSource {
    override suspend fun getCurrentLocation(): LocationResponse {
        val response =
            safeApiCall {
                client.get(baseUrl)
            }
        return getClassByResponse<LocationResponse>(response = response, json = json)
    }
}