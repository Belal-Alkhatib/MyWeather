package com.thechance.myweather.data.repository

import android.util.Log
import com.thechance.myweather.data.repository.dataSource.LocationDataSource
import com.thechance.myweather.data.response.toLocation
import com.thechance.myweather.domain.entity.Location
import com.thechance.myweather.domain.repository.LocationRepository

class LocationRepositoryImpl(
    private val locationDataSource: LocationDataSource,
): LocationRepository {
        override suspend fun getCurrentLocation(): Location { //LocationResponse
            Log.e("bk", "location: ${locationDataSource.getCurrentLocation().toLocation()}")
        return locationDataSource.getCurrentLocation().toLocation()
    }

}