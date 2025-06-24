package com.thechance.myweather.ui.screen.weatherOverview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thechance.myweather.domain.entity.WeatherOverview
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
import com.thechance.myweather.ui.mapper.toWeatherOverviewUiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherOverviewViewModel(
    private val getWeather: GetWeatherUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(WeatherOverviewUiState())
    val state: StateFlow<WeatherOverviewUiState> = _state.asStateFlow()

    init {
        getWeatherOverview()
    }

    fun onRetryClick() {
        getWeatherOverview()
    }

    private fun getWeatherOverview() {
        _state.update { it.copy(isLoading = true) }

        tryToExecute<WeatherOverview>(
            call = getWeather::invoke,
            onSuccess = ::onGetWeatherOverviewSuccess,
        )
    }

    private fun onGetWeatherOverviewSuccess(weatherOverview: WeatherOverview) {
        val weatherOverviewUiState = weatherOverview.toWeatherOverviewUiState()
        weatherOverviewUiState.apply {
            _state.update {
                it.copy(
                    cityName = cityName,
                    isDay = isDay,
                    currentWeatherInfoUiState = currentWeatherInfoUiState,
                    weatherDetails = weatherDetails,
                    todayWeather = todayWeather,
                    weeklyWeather = weeklyWeather,
                    isLoading = false,
                    errorTypeUiState = null
                )
            }
        }
    }

    private fun <T> tryToExecute(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (MyWeatherException) -> Unit = { updateErrorUiStateByException(it) },
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                call().also(onSuccess)
            } catch (exception: MyWeatherException) {
                onError(exception)
            }
        }
    }

    private fun updateErrorUiStateByException(exception: MyWeatherException) {
        val errorTypeUiState = when (exception) {
            LocationAccessException -> ErrorTypeUiState.LOCATION_ACCESS
            LocationPermissionDeniedException -> ErrorTypeUiState.LOCATION_PERMISSION_DENIED
            UnknownLastLocationException -> ErrorTypeUiState.UNKNOWN_LAST_LOCATION

            NoInternetException -> ErrorTypeUiState.NO_INTERNET
            ServerException -> ErrorTypeUiState.SERVER
            TimeoutException -> ErrorTypeUiState.TIMEOUT
            UnknownNetworkException -> ErrorTypeUiState.UNKNOWN_NETWORK
            AddressAccessException -> ErrorTypeUiState.ADDRESS_ACCESS
        }

        _state.update { it.copy(errorTypeUiState = errorTypeUiState, isLoading = false) }
    }
}