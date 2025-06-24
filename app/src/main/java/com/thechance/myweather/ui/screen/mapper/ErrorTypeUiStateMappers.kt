package com.thechance.myweather.ui.screen.mapper

import androidx.annotation.StringRes
import com.thechance.myweather.ui.screen.weatherOverview.ErrorTypeUiState
import com.thechance.myweather.R

@StringRes
fun ErrorTypeUiState.getErrorTitleResource(): Int {
    return when(this){
        ErrorTypeUiState.LOCATION_ACCESS -> R.string.location_access_error_title
        ErrorTypeUiState.LOCATION_PERMISSION_DENIED -> R.string.location_permission_denied_title
        ErrorTypeUiState.UNKNOWN_LAST_LOCATION -> R.string.unknown_last_location_title
        ErrorTypeUiState.NO_INTERNET -> R.string.no_internet_error_title
        ErrorTypeUiState.SERVER -> R.string.server_error_title
        ErrorTypeUiState.TIMEOUT -> R.string.timeout_error_title
        ErrorTypeUiState.UNKNOWN_NETWORK -> R.string.unknown_network_error_title
        ErrorTypeUiState.ADDRESS_ACCESS -> R.string.address_access_error_title
    }
}

@StringRes
fun ErrorTypeUiState.getErrorDescriptionResource(): Int {
    return when(this){
        ErrorTypeUiState.LOCATION_ACCESS -> R.string.location_access_error_description
        ErrorTypeUiState.LOCATION_PERMISSION_DENIED -> R.string.location_permission_denied_title
        ErrorTypeUiState.UNKNOWN_LAST_LOCATION -> R.string.unknown_last_location_description
        ErrorTypeUiState.NO_INTERNET -> R.string.no_internet_error_description
        ErrorTypeUiState.SERVER -> R.string.server_error_description
        ErrorTypeUiState.TIMEOUT -> R.string.timeout_error_description
        ErrorTypeUiState.UNKNOWN_NETWORK -> R.string.unknown_network_error_description
        ErrorTypeUiState.ADDRESS_ACCESS -> R.string.access_access_error_description
    }
}