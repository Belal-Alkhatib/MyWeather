package com.thechance.myweather.domain.exception


sealed class MyWeatherException: Exception() {

    sealed class NetworkException : MyWeatherException() {
        data object NoInternetException : NetworkException()
        data object TimeoutException : NetworkException()
        data object ServerException : NetworkException()
        data object UnknownNetworkException : NetworkException()
    }


    sealed class LocationException: MyWeatherException() {
        data object UnknownLastLocationException: LocationException()
        data object LocationAccessException: LocationException()
        data object LocationPermissionDeniedException: LocationException()
    }
}