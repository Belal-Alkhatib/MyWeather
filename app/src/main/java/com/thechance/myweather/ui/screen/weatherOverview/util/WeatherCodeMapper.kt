package com.thechance.myweather.ui.screen.weatherOverview.util

import androidx.annotation.DrawableRes
import com.thechance.myweather.R

private val dayIcons: Map<Int, Int> = mapOf(
    0 to R.drawable.image_day_code_0,
    1 to R.drawable.image_day_code_1,
    2 to R.drawable.image_day_code_2,
    3 to R.drawable.image_day_code_3,
    45 to R.drawable.image_day_code_45,
    48 to R.drawable.image_day_code_48,
    51 to R.drawable.image_day_code_51,
    53 to R.drawable.image_day_code_53,
    55 to R.drawable.image_day_code_55,
    56 to R.drawable.image_day_code_56,
    57 to R.drawable.image_day_code_57,
    61 to R.drawable.image_day_code_61,
    63 to R.drawable.image_day_code_63,
    65 to R.drawable.image_day_code_65,
    66 to R.drawable.image_day_code_66,
    67 to R.drawable.image_day_code_67,
    71 to R.drawable.image_day_code_71,
    73 to R.drawable.image_day_code_73,
    75 to R.drawable.image_day_code_75,
    77 to R.drawable.image_day_code_77,
    80 to R.drawable.image_day_code_80,
    81 to R.drawable.image_day_code_81,
    82 to R.drawable.image_day_code_82,
    85 to R.drawable.image_day_code_85,
    86 to R.drawable.image_day_code_86,
    95 to R.drawable.image_day_code_95,
    96 to R.drawable.image_day_code_96,
    99 to R.drawable.image_day_code_99,
)

private val nightIcons: Map<Int, Int> = mapOf(
    0 to R.drawable.image_night_code_0,
    1 to R.drawable.image_night_code_1,
    2 to R.drawable.image_night_code_2,
    3 to R.drawable.image_night_code_3,
    45 to R.drawable.image_night_code_45,
    48 to R.drawable.image_night_code_48,
    51 to R.drawable.image_night_code_51,
    53 to R.drawable.image_night_code_53,
    55 to R.drawable.image_night_code_55,
    56 to R.drawable.image_night_code_56,
    57 to R.drawable.image_night_code_57,
    61 to R.drawable.image_night_code_61,
    63 to R.drawable.image_night_code_63,
    65 to R.drawable.image_night_code_65,
    66 to R.drawable.image_night_code_66,
    67 to R.drawable.image_night_code_67,
    71 to R.drawable.image_night_code_71,
    73 to R.drawable.image_night_code_73,
    75 to R.drawable.image_night_code_75,
    77 to R.drawable.image_night_code_77,
    80 to R.drawable.image_night_code_80,
    81 to R.drawable.image_night_code_81,
    82 to R.drawable.image_night_code_82,
    85 to R.drawable.image_night_code_85,
    86 to R.drawable.image_night_code_86,
    95 to R.drawable.image_night_code_95,
    96 to R.drawable.image_night_code_96,
    99 to R.drawable.image_night_code_99,
)

@DrawableRes
fun getIconResourceByWeatherCode(code: Int, isDay: Boolean): Int {
    return if (isDay) dayIcons[code] ?: R.drawable.image_day_code_0
    else nightIcons[code] ?: R.drawable.image_night_code_0
}