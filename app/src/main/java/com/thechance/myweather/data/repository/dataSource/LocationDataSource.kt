package com.thechance.myweather.data.repository.dataSource

import com.thechance.myweather.data.response.LocationResponse

interface LocationDataSource {
    suspend fun getCurrentLocation(): LocationResponse
}