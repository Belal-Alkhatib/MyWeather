package com.thechance.myweather.domain.usecase

import android.util.Log
import com.thechance.myweather.domain.entity.CurrentWeather
import com.thechance.myweather.domain.entity.DailyForecast
import com.thechance.myweather.domain.entity.HourlyForecast
import com.thechance.myweather.domain.entity.Location
import com.thechance.myweather.domain.entity.WeatherOverview
import com.thechance.myweather.domain.entity.WeatherUnit
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.domain.entity.toWeatherOverviewUiState
import com.thechance.myweather.domain.exception.MyWeatherException
import com.thechance.myweather.domain.repository.LocationRepository
import com.thechance.myweather.domain.repository.WeatherRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.time.LocalDate
import java.time.LocalTime

class GetWeatherUseCase(
    private val locationRepository: LocationRepository,
    private val weatherRepository: WeatherRepository
) {

    //region dummy weather
    val dummyWeather = WeatherOverview(
        current = CurrentWeather(
            isDay = true,
            cityName = "gaza",
            temperature = WeatherValue(28.0, WeatherUnit.Celsius),
            feelsLike = WeatherValue(28.0, WeatherUnit.Celsius),
            weatherCode = 1,
            humidity = WeatherValue(50, WeatherUnit.Percent),
            rain = WeatherValue(0.0, WeatherUnit.NoUnit),
            uvIndex = WeatherValue(8.0, WeatherUnit.NoUnit),
            pressure =WeatherValue(1008.0, WeatherUnit.Hpa),
            windSpeed =WeatherValue(28.0, WeatherUnit.KmPerHour)
        ),
        hourly = listOf(
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 1
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 2
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 3
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 1
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 1
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 1
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 1
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 1
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 1
            ),
            HourlyForecast(
                time = LocalTime.now(),
                temperature =  WeatherValue(28.0, WeatherUnit.Celsius),
                weatherCode = 1
            ),
        ),
        daily = listOf(
            DailyForecast(
                date = LocalDate.now(),
                weatherCode = 1,
                highTemperature = WeatherValue(28.0, WeatherUnit.Celsius),
                lowTemperature = WeatherValue(18.0, WeatherUnit.Celsius)
            ),

            DailyForecast(
                date = LocalDate.now(),
                weatherCode = 1,
                highTemperature = WeatherValue(28.0, WeatherUnit.Celsius),
                lowTemperature = WeatherValue(18.0, WeatherUnit.Celsius)
            ),
            DailyForecast(
                date = LocalDate.now(),
                weatherCode = 1,
                highTemperature = WeatherValue(28.0, WeatherUnit.Celsius),
                lowTemperature = WeatherValue(18.0, WeatherUnit.Celsius)
            ),
            DailyForecast(
                date = LocalDate.now(),
                weatherCode = 1,
                highTemperature = WeatherValue(28.0, WeatherUnit.Celsius),
                lowTemperature = WeatherValue(18.0, WeatherUnit.Celsius)
            ),
            DailyForecast(
                date = LocalDate.now(),
                weatherCode = 1,
                highTemperature = WeatherValue(28.0, WeatherUnit.Celsius),
                lowTemperature = WeatherValue(18.0, WeatherUnit.Celsius)
            ),
            DailyForecast(
                date = LocalDate.now(),
                weatherCode = 1,
                highTemperature = WeatherValue(28.0, WeatherUnit.Celsius),
                lowTemperature = WeatherValue(18.0, WeatherUnit.Celsius)
            ),
            DailyForecast(
                date = LocalDate.now(),
                weatherCode = 1,
                highTemperature = WeatherValue(28.0, WeatherUnit.Celsius),
                lowTemperature = WeatherValue(18.0, WeatherUnit.Celsius)
            ),

            )
    )
    //endregion

    suspend operator fun invoke(): WeatherOverview {
        //delay(3000)
        val weatherOverview = weatherRepository.getWeatherOverviewByLocation(locationRepository.getCurrentLocation())
//        val weatherOverview = weatherRepository.getWeatherOverviewByLocation(Location(
//            latitude = -36.8485,
//            longitude = 174.7633,
//            cityName = "North Shore"
//        ))
        Log.e("bk", weatherOverview.toString())
        return weatherOverview
    }

}