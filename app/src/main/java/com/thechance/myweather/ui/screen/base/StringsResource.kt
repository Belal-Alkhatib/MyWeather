package com.thechance.myweather.ui.screen.base

interface StringsResource {

    // Location Errors
    val locationAccessErrorTitle: String
    val locationAccessErrorDescription: String

    val locationPermissionDeniedTitle: String
    val locationPermissionDeniedDescription: String

    val unknownLastLocationTitle: String
    val unknownLastLocationDescription: String

    // Network Errors
    val noInternetErrorTitle: String
    val noInternetErrorDescription: String

    val serverErrorTitle: String
    val serverErrorDescription: String

    val timeoutErrorTitle: String
    val timeoutErrorDescription: String

    val unknownNetworkErrorTitle: String
    val unknownNetworkErrorDescription: String

    val addressAccessErrorTitle: String
    val addressAccessErrorDescription: String

    val unexpectedErrorMessageTitle: String
    val unexpectedErrorMessageDescription: String

    val clearSkyWeatherDescription: String
    val partlyCloudyWeatherDescription: String
    val fogWeatherDescription: String
    val drizzleWeatherDescription: String
    val freezingDrizzleWeatherDescription: String
    val rainWeatherDescription: String
    val freezingRainWeatherDescription: String
    val snowWeatherDescription: String
    val snowGrainsWeatherDescription: String
    val snowShowersWeatherDescription: String
    val rainShowersWeatherDescription: String
    val thunderstormWeatherDescription: String
    val thunderstormHailWeatherDescription: String
    val unknownWeatherWeatherDescription: String
}
