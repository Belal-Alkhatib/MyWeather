package com.thechance.myweather.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalMyWeatherAppColors = staticCompositionLocalOf { DayAppColors }
val LocalMyWeatherAppDimension = staticCompositionLocalOf { MyWeatherAppDimens }

@Composable
fun MyWeatherTheme(
    isDay: Boolean,
    content: @Composable () -> Unit
) {
    val appColors = if (isDay) DayAppColors else NightAppColors

    CompositionLocalProvider(LocalMyWeatherAppColors provides appColors, LocalMyWeatherAppDimension provides MyWeatherAppDimens) {
        MaterialTheme(
            typography = MyWeatherTypography,
            content = content
        )
    }
}

object MyWeatherAppTheme {
    val colors: MyWeatherAppColors
        @Composable
        get() = LocalMyWeatherAppColors.current

    val dimensions: MyWeatherAppDimens
        @Composable
        get() = LocalMyWeatherAppDimension.current
}