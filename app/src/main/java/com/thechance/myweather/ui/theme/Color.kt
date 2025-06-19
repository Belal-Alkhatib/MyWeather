package com.thechance.myweather.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val Skyblue = Color(0xFF87CEFA)
private val MidDayBorder = Color(0x14060414)
private val MidDayOnBackgroundPrimary = Color(0xB2FFFFFF)
private val MidDayOnBackgroundSecondary = Color(0x14060414)
private val MidDayDivider = Color(0x3D060414)
private val MidnightSecondary = Color(0xFF0D0C19)
private val MidDayBlur = Color(0x4700619D)

private val MidnightBorder = Color(0x14FFFFFF)
private val MidnightOnBackgroundPrimary = Color(0xB2060414)
private val MidnightOnBackgroundSecondary = Color(0x14FFFFFF)
private val MidnightDivider = Color(0x3DFFFFFF)
private val MidnightPrimary = Color(0xFF060414)
private val MidNightBlur = Color(0x33C0B7FF)

private val WhitPrimary = Color(0xFFFFFFFF)
private val WhitSecondary = Color(0xDEFFFFFF)
private val WhitTertiary = Color(0x99FFFFFF)

private val BlackPrimary = Color(0xFF060414)
private val BlackSecondary = Color(0xDE060414)
private val BlackTertiary = Color(0x99060414)

private val GrayPrimary = Color(0xFF323232)

val DayAppColors = MyWeatherAppColors(
    text = MyWeatherAppTextColors(
        primaryText = BlackPrimary,
        secondaryText= BlackSecondary,
        tertiaryText = BlackTertiary
    ),
    background = MyWeatherAppBackgroundColors(
        backgroundBrush = Brush.verticalGradient(colors = listOf(Skyblue, WhitPrimary)),
        onBackgroundPrimary = MidDayOnBackgroundPrimary,
        onBackgroundSecondary = MidDayOnBackgroundSecondary
    ),
    border = MidDayBorder,
    divider = MidDayDivider,
    skyblue = Skyblue,
    gray = GrayPrimary,
    blur = MidDayBlur

)

val NightAppColors = MyWeatherAppColors(
    text = MyWeatherAppTextColors(
        primaryText = WhitPrimary,
        secondaryText= WhitSecondary,
        tertiaryText = WhitTertiary
    ),
    background = MyWeatherAppBackgroundColors(
        backgroundBrush = Brush.verticalGradient(colors = listOf(MidnightPrimary, MidnightSecondary)),
        onBackgroundPrimary = MidnightOnBackgroundPrimary,
        onBackgroundSecondary = MidnightOnBackgroundSecondary
    ),
    border = MidnightBorder,
    divider = MidnightDivider,
    skyblue = Skyblue,
    gray = WhitPrimary,
    blur = MidNightBlur
)

data class MyWeatherAppColors(
    val text: MyWeatherAppTextColors,
    val background: MyWeatherAppBackgroundColors,
    val border: Color,
    val divider: Color,
    val skyblue: Color,
    val gray: Color,
    val blur: Color,
)

data class MyWeatherAppTextColors(
    val primaryText: Color,
    val secondaryText: Color,
    val tertiaryText: Color,
)

data class MyWeatherAppBackgroundColors(
    val backgroundBrush: Brush,
    val onBackgroundPrimary: Color,
    val onBackgroundSecondary: Color,
)