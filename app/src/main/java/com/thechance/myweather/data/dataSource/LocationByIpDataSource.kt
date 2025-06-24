package com.thechance.myweather.data.dataSource

import com.thechance.myweather.data.repository.dataSource.LocationDataSource
import com.thechance.myweather.data.response.LocationResponse
import com.thechance.myweather.data.utils.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class LocationByIpDataSource(
    private val client: HttpClient,
    private val baseUrl: String,
) : LocationDataSource {
    override suspend fun getCurrentLocation(): LocationResponse {
        val response = safeApiCall { client.get(baseUrl) }
        return response.body()
    }
}