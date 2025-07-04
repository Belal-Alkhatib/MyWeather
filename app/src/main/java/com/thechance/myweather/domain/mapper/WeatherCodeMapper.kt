package com.thechance.myweather.domain.mapper

import com.thechance.myweather.domain.entity.WeatherType

fun Int.toWeatherType(): WeatherType {
    return when (this) {
        0 -> WeatherType.ClearSky
        1 -> WeatherType.MainlyClear
        2 -> WeatherType.PartlyCloudy
        3 -> WeatherType.Overcast
        45 -> WeatherType.Fog
        48 -> WeatherType.DepositingRimeFog
        51 -> WeatherType.LightDrizzle
        53 -> WeatherType.ModerateDrizzle
        55 -> WeatherType.DenseDrizzle
        56 -> WeatherType.LightFreezingDrizzle
        57 -> WeatherType.DenseFreezingDrizzle
        61 -> WeatherType.SlightRain
        63 -> WeatherType.ModerateRain
        65 -> WeatherType.HeavyRain
        66 -> WeatherType.LightFreezingRain
        67 -> WeatherType.HeavyFreezingRain
        71 -> WeatherType.LightSnow
        73 -> WeatherType.ModerateSnow
        75 -> WeatherType.HeavySnow
        77 -> WeatherType.SnowGrains
        80 -> WeatherType.SlightRainShowers
        81 -> WeatherType.ModerateRainShowers
        82 -> WeatherType.ViolentRainShowers
        85 -> WeatherType.SlightSnowShowers
        86 -> WeatherType.HeavySnowShowers
        95 -> WeatherType.Thunderstorm
        96 -> WeatherType.ThunderstormWithSlightHail
        99 -> WeatherType.ThunderstormWithHeavyHail
        else -> WeatherType.Unknown
    }
}