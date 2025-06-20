package com.thechance.myweather.ui.resource

import android.content.Context
import com.thechance.myweather.R
import com.thechance.myweather.ui.screen.base.StringsResource

class DefaultStringsResource(private val context: Context) : StringsResource {
    override val locationAccessErrorTitle: String
        get() = context.getString(R.string.location_access_error_title)

    override val locationAccessErrorDescription: String
        get() = context.getString(R.string.location_access_error_description)

    override val locationPermissionDeniedTitle: String
        get() = context.getString(R.string.location_permission_denied_title)

    override val locationPermissionDeniedDescription: String
        get() = context.getString(R.string.location_permission_denied_description)

    override val unknownLastLocationTitle: String
        get() = context.getString(R.string.unknown_last_location_title)

    override val unknownLastLocationDescription: String
        get() = context.getString(R.string.unknown_last_location_description)

    override val noInternetErrorTitle: String
        get() = context.getString(R.string.no_internet_error_title)

    override val noInternetErrorDescription: String
        get() = context.getString(R.string.no_internet_error_description)

    override val serverErrorTitle: String
        get() = context.getString(R.string.server_error_title)

    override val serverErrorDescription: String
        get() = context.getString(R.string.server_error_description)

    override val timeoutErrorTitle: String
        get() = context.getString(R.string.timeout_error_title)

    override val timeoutErrorDescription: String
        get() = context.getString(R.string.timeout_error_description)

    override val unknownNetworkErrorTitle: String
        get() = context.getString(R.string.unknown_network_error_title)

    override val unknownNetworkErrorDescription: String
        get() = context.getString(R.string.unknown_network_error_description)
    
    override val addressAccessErrorTitle: String
        get() = context.getString(R.string.address_access_error)
    override val addressAccessErrorDescription: String
        get() = context.getString(R.string.unable_to_access_your_address)

    override val unexpectedErrorMessageTitle: String
        get() =  context.getString(R.string.unexpected_error_title)
    override val unexpectedErrorMessageDescription: String
        get() = context.getString(R.string.unexpected_error_description)


    override val clearSkyWeatherDescription: String
        get() = context.getString(R.string.clear_sky)

    override val partlyCloudyWeatherDescription: String
        get() = context.getString(R.string.partly_cloudy)

    override val fogWeatherDescription: String
        get() = context.getString(R.string.fog)

    override val drizzleWeatherDescription: String
        get() = context.getString(R.string.drizzle)

    override val freezingDrizzleWeatherDescription: String
        get() = context.getString(R.string.freezing_drizzle)

    override val rainWeatherDescription: String
        get() = context.getString(R.string.rain_description)

    override val freezingRainWeatherDescription: String
        get() = context.getString(R.string.freezing_rain)

    override val snowWeatherDescription: String
        get() = context.getString(R.string.snow)

    override val snowGrainsWeatherDescription: String
        get() = context.getString(R.string.snow_grains)

    override val snowShowersWeatherDescription: String
        get() = context.getString(R.string.snow_showers)

    override val rainShowersWeatherDescription: String
        get() = context.getString(R.string.rain_showers)

    override val thunderstormWeatherDescription: String
        get() = context.getString(R.string.thunderstorm)

    override val thunderstormHailWeatherDescription: String
        get() = context.getString(R.string.thunderstorm_hail)

    override val unknownWeatherWeatherDescription: String
        get() = context.getString(R.string.unknown_weather)
}
