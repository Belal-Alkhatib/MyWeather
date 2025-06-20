package com.thechance.myweather.ui.screen.weatherOverview.stateHolder

import android.util.Log
import android.util.Log.e
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thechance.myweather.domain.entity.WeatherOverview
import com.thechance.myweather.domain.entity.toWeatherOverviewUiState
import com.thechance.myweather.domain.exception.MyWeatherException
import com.thechance.myweather.domain.exception.MyWeatherException.LocationException.AddressAccessException
import com.thechance.myweather.domain.exception.MyWeatherException.LocationException.LocationAccessException
import com.thechance.myweather.domain.exception.MyWeatherException.LocationException.LocationPermissionDeniedException
import com.thechance.myweather.domain.exception.MyWeatherException.LocationException.UnknownLastLocationException
import com.thechance.myweather.domain.exception.MyWeatherException.NetworkException.NoInternetException
import com.thechance.myweather.domain.exception.MyWeatherException.NetworkException.ServerException
import com.thechance.myweather.domain.exception.MyWeatherException.NetworkException.TimeoutException
import com.thechance.myweather.domain.exception.MyWeatherException.NetworkException.UnknownNetworkException
import com.thechance.myweather.domain.usecase.GetWeatherUseCase
import com.thechance.myweather.ui.screen.base.BaseUiState
import com.thechance.myweather.ui.screen.base.ErrorMessageUiState
import com.thechance.myweather.ui.screen.base.StringsResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherOverviewViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val stringsResource: StringsResource
) : ViewModel() {
    private val _state = MutableStateFlow(WeatherOverviewUiState())
    val state: StateFlow<WeatherOverviewUiState> = _state.asStateFlow()

    init { getWeatherOverview() }

    fun onRetryClick() { getWeatherOverview() }

    private fun getWeatherOverview() {
        updateLoadingState()
        tryToExecute<WeatherOverview>(
            call = getWeatherUseCase::invoke,
            onSuccess = ::onGetWeatherOverviewSuccess,
        )
    }

    private fun onGetWeatherOverviewSuccess(weatherOverview: WeatherOverview) {
        e("bk", "onSuccess: ${weatherOverview.toWeatherOverviewUiState()}")
        updateLoadingState(isLoading = false)
        updateErrorState(
            errorMessageUiState = _state.value.baseUiState.errorMessage.copy(title = null)
        )

        val weatherOverviewUiState = weatherOverview.toWeatherOverviewUiState()
        weatherOverviewUiState.apply {
            _state.update {
                it.copy(
                    cityName = cityName,
                    isDay = false,
                    currentWeatherInfoUiState = currentWeatherInfoUiState.copy(
                        description = getWeatherDescriptionByWeatherCode(
                            currentWeatherInfoUiState.imageCode
                        )
                    ),
                    weatherDetails = weatherDetails,
                    todayWeather = todayWeather,
                    weeklyWeather = weeklyWeather,
                )
            }
        }
    }

    private fun <T> tryToExecute(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (MyWeatherException) -> Unit = {},
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                call().also(onSuccess)
            } catch (exception: MyWeatherException) {
                onGetError(exception)
                onError(exception)
            }
        }
    }

    private fun onGetError(exception: MyWeatherException) {
        Log.e("bk", "onGetError : $exception")
        updateLoadingState(isLoading = false)

        val errorMessageUiState = when (exception) {
            LocationAccessException -> ErrorMessageUiState(
                title = stringsResource.locationAccessErrorTitle,
                description = stringsResource.locationAccessErrorDescription
            )

            LocationPermissionDeniedException -> ErrorMessageUiState(
                title = stringsResource.locationPermissionDeniedTitle,
                description = stringsResource.locationPermissionDeniedDescription
            )

            UnknownLastLocationException -> ErrorMessageUiState(
                title = stringsResource.unknownLastLocationTitle,
                description = stringsResource.unknownLastLocationDescription
            )

            NoInternetException -> ErrorMessageUiState(
                title = stringsResource.noInternetErrorTitle,
                description = stringsResource.noInternetErrorDescription
            )

            ServerException -> ErrorMessageUiState(
                title = stringsResource.serverErrorTitle,
                description = stringsResource.serverErrorDescription
            )

            TimeoutException -> ErrorMessageUiState(
                title = stringsResource.timeoutErrorTitle,
                description = stringsResource.timeoutErrorDescription
            )

            UnknownNetworkException -> ErrorMessageUiState(
                title = stringsResource.unknownNetworkErrorTitle,
                description = stringsResource.unknownNetworkErrorDescription
            )

            AddressAccessException -> ErrorMessageUiState(
                title = stringsResource.addressAccessErrorTitle,
                description = stringsResource.addressAccessErrorDescription
            )
        }

        updateErrorState(errorMessageUiState)
    }


    private fun getWeatherDescriptionByWeatherCode(code: Int): String {
        return when (code) {
            0 -> stringsResource.clearSkyWeatherDescription
            1, 2, 3 -> stringsResource.partlyCloudyWeatherDescription
            45, 48 -> stringsResource.fogWeatherDescription
            51, 53, 55 -> stringsResource.drizzleWeatherDescription
            56, 57 -> stringsResource.freezingDrizzleWeatherDescription
            61, 63, 65 -> stringsResource.rainWeatherDescription
            66, 67 -> stringsResource.freezingRainWeatherDescription
            71, 73, 75 -> stringsResource.snowWeatherDescription
            77 -> stringsResource.snowGrainsWeatherDescription
            80, 81, 82 -> stringsResource.rainShowersWeatherDescription
            85, 86 -> stringsResource.snowShowersWeatherDescription
            95 -> stringsResource.thunderstormWeatherDescription
            96, 99 -> stringsResource.thunderstormHailWeatherDescription
            else -> stringsResource.unknownWeatherWeatherDescription
        }
    }

    private fun updateLoadingState(isLoading: Boolean = true) {
        _state.update { it.copy(baseUiState = BaseUiState(isLoading = isLoading)) }
    }

    private fun updateErrorState(errorMessageUiState: ErrorMessageUiState) {
        _state.update {
            it.copy(baseUiState = BaseUiState(errorMessage = errorMessageUiState))
        }
    }
}