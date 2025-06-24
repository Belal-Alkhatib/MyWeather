package com.thechance.myweather.ui.screen.mapper

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.thechance.myweather.R
import com.thechance.myweather.domain.entity.WeatherType

@DrawableRes
fun getWeatherIconByWeatherType(type: WeatherType, isDay: Boolean): Int {
    return when (type) {
        WeatherType.ClearSky -> if (isDay) R.drawable.image_day_code_0 else R.drawable.image_night_code_0
        WeatherType.MainlyClear -> if (isDay) R.drawable.image_day_code_1 else R.drawable.image_night_code_1
        WeatherType.PartlyCloudy -> if (isDay) R.drawable.image_day_code_2 else R.drawable.image_night_code_2
        WeatherType.Overcast -> if (isDay) R.drawable.image_day_code_3 else R.drawable.image_night_code_3
        WeatherType.Fog -> if (isDay) R.drawable.image_day_code_45 else R.drawable.image_night_code_45
        WeatherType.DepositingRimeFog -> if (isDay) R.drawable.image_day_code_48 else R.drawable.image_night_code_48
        WeatherType.LightDrizzle -> if (isDay) R.drawable.image_day_code_51 else R.drawable.image_night_code_51
        WeatherType.ModerateDrizzle -> if (isDay) R.drawable.image_day_code_53 else R.drawable.image_night_code_53
        WeatherType.DenseDrizzle -> if (isDay) R.drawable.image_day_code_55 else R.drawable.image_night_code_55
        WeatherType.LightFreezingDrizzle -> if (isDay) R.drawable.image_day_code_56 else R.drawable.image_night_code_56
        WeatherType.DenseFreezingDrizzle -> if (isDay) R.drawable.image_day_code_57 else R.drawable.image_night_code_57
        WeatherType.SlightRain -> if (isDay) R.drawable.image_day_code_61 else R.drawable.image_night_code_61
        WeatherType.ModerateRain -> if (isDay) R.drawable.image_day_code_63 else R.drawable.image_night_code_63
        WeatherType.HeavyRain -> if (isDay) R.drawable.image_day_code_65 else R.drawable.image_night_code_65
        WeatherType.LightFreezingRain -> if (isDay) R.drawable.image_day_code_66 else R.drawable.image_night_code_66
        WeatherType.HeavyFreezingRain -> if (isDay) R.drawable.image_day_code_67 else R.drawable.image_night_code_67
        WeatherType.LightSnow -> if (isDay) R.drawable.image_day_code_71 else R.drawable.image_night_code_71
        WeatherType.ModerateSnow -> if (isDay) R.drawable.image_day_code_73 else R.drawable.image_night_code_73
        WeatherType.HeavySnow -> if (isDay) R.drawable.image_day_code_75 else R.drawable.image_night_code_75
        WeatherType.SnowGrains -> if (isDay) R.drawable.image_day_code_77 else R.drawable.image_night_code_77
        WeatherType.SlightRainShowers -> if (isDay) R.drawable.image_day_code_80 else R.drawable.image_night_code_80
        WeatherType.ModerateRainShowers -> if (isDay) R.drawable.image_day_code_81 else R.drawable.image_night_code_81
        WeatherType.ViolentRainShowers -> if (isDay) R.drawable.image_day_code_82 else R.drawable.image_night_code_82
        WeatherType.SlightSnowShowers -> if (isDay) R.drawable.image_day_code_85 else R.drawable.image_night_code_85
        WeatherType.HeavySnowShowers -> if (isDay) R.drawable.image_day_code_86 else R.drawable.image_night_code_86
        WeatherType.Thunderstorm -> if (isDay) R.drawable.image_day_code_95 else R.drawable.image_night_code_95
        WeatherType.ThunderstormWithSlightHail -> if (isDay) R.drawable.image_day_code_96 else R.drawable.image_night_code_96
        WeatherType.ThunderstormWithHeavyHail -> if (isDay) R.drawable.image_day_code_99 else R.drawable.image_night_code_99
        WeatherType.Unknown -> if (isDay) R.drawable.image_day_code_0 else R.drawable.image_night_code_0
    }
}

@StringRes
fun getWeatherDescriptionByWeatherType(type: WeatherType): Int {
     return when(type){
         WeatherType.ClearSky -> R.string.clear_sky
         WeatherType.MainlyClear, WeatherType.PartlyCloudy, WeatherType.Overcast-> R.string.partly_cloudy
         WeatherType.Fog, WeatherType.DepositingRimeFog -> R.string.fog
         WeatherType.LightDrizzle, WeatherType.ModerateDrizzle, WeatherType.DenseDrizzle -> R.string.drizzle
         WeatherType.LightFreezingDrizzle, WeatherType.DenseFreezingDrizzle -> R.string.freezing_drizzle
         WeatherType.SlightRain, WeatherType.ModerateRain, WeatherType.HeavyRain -> R.string.rain_description
         WeatherType.LightFreezingRain, WeatherType.HeavyFreezingRain -> R.string.freezing_rain
         WeatherType.LightSnow, WeatherType.ModerateSnow, WeatherType.HeavySnow  -> R.string.snow
         WeatherType.SnowGrains -> R.string.snow_grains
         WeatherType.SlightRainShowers, WeatherType.ModerateRainShowers, WeatherType.ViolentRainShowers-> R.string.rain_showers
         WeatherType.SlightSnowShowers, WeatherType.HeavySnowShowers-> R.string.snow_showers
         WeatherType.Thunderstorm -> R.string.thunderstorm
         WeatherType.ThunderstormWithSlightHail, WeatherType.ThunderstormWithHeavyHail-> R.string.thunderstorm_hail
         WeatherType.Unknown -> R.string.unknown_weather
     }
 }