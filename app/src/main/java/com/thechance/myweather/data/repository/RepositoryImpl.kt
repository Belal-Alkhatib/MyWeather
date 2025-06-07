package com.thechance.myweather.data.repository

import com.thechance.myweather.data.dataSource.LocationDataSource
import com.thechance.myweather.data.dataSource.WeatherDataSource
import com.thechance.myweather.domain.repository.Repository

class RepositoryImpl(
    private val locationDataSource: LocationDataSource,
    private val weatherDataSource: WeatherDataSource
): Repository {
}