package com.thechance.myweather.domain.repository

import com.thechance.myweather.domain.entity.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location
}