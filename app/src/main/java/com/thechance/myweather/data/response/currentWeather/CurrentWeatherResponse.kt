package com.thechance.myweather.data.response.currentWeather

import com.thechance.myweather.domain.entity.CurrentWeather
import com.thechance.myweather.domain.entity.WeatherUnit
import com.thechance.myweather.domain.entity.WeatherValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    @SerialName("apparent_temperature")
    val apparentTemperature: Double? = null,
    @SerialName("interval")
    val interval: Int? = null,
    @SerialName("is_day")
    val isDay: Int? = null,
    @SerialName("pressure_msl")
    val pressure: Double? = null,
    @SerialName("rain")
    val rain: Double? = null,
    @SerialName("relative_humidity_2m")
    val relativeHumidity: Int? = null,
    @SerialName("temperature_2m")
    val temperature: Double? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("weather_code")
    val weatherCode: Int? = null,
    @SerialName("wind_speed_10m")
    val windSpeed: Double? = null
)

fun CurrentWeatherResponse.toCurrentWeather(
    units: CurrentWeatherUnitsResponse?,
    uvIndex: Double,
    cityName: String = ""
): CurrentWeather {
    return CurrentWeather(
        isDay = this.isDay == 1,
        cityName = cityName,
        temperature = WeatherValue(this.temperature ?: 0.0, WeatherUnit.fromSymbol(units?.temperature.orEmpty())),
        feelsLike = WeatherValue(this.apparentTemperature ?: 0.0, WeatherUnit.fromSymbol(units?.apparentTemperature.orEmpty())),
        weatherCode = this.weatherCode ?: 0,
        humidity = WeatherValue(this.relativeHumidity ?: 0, WeatherUnit.fromSymbol(units?.relativeHumidity.orEmpty())),
        rain = WeatherValue(this.rain ?: 0.0, WeatherUnit.fromSymbol(units?.rain.orEmpty())),
        uvIndex = WeatherValue(uvIndex, WeatherUnit.NoUnit),
        pressure = WeatherValue(this.pressure ?: 0.0, WeatherUnit.fromSymbol(units?.pressure.orEmpty())),
        windSpeed = WeatherValue(this.windSpeed ?: 0.0, WeatherUnit.fromSymbol(units?.windSpeed.orEmpty()))
    )
}