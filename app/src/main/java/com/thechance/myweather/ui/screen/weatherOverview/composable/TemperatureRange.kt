package com.thechance.myweather.ui.screen.weatherOverview.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion.then
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.myweather.R
import com.thechance.myweather.domain.entity.WeatherUnit
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.colors
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.dimensions
import com.thechance.myweather.ui.theme.MyWeatherTheme

@Composable
fun TemperatureRange(
    highTemperature: WeatherValue<Int>,
    lowTemperature: WeatherValue<Int>,
    modifier: Modifier = Modifier,
    contentColor: Color = colors.text.tertiaryText,
    contentTextStyle: TextStyle= MaterialTheme.typography.bodyLarge,
    hasABackground: Boolean = false,
    dividerPadding: Modifier = Modifier.padding(
        vertical = dimensions.spacing2,
        horizontal = dimensions.spacing8
    )
) {
    val background = if (hasABackground) Modifier.background(
        color = colors.background.onBackgroundSecondary,
        shape = RoundedCornerShape(percent = 50)
    ).padding(horizontal = dimensions.spacing24, vertical = dimensions.spacing8) else Modifier

    Row(
        modifier
            .wrapContentWidth()
            .height(IntrinsicSize.Max)
            .then(background),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        ArrowIcon(tint = contentColor, contentDescription = "high temperature is ${highTemperature.value}")

        Text(
            modifier = Modifier.padding(start = dimensions.spacing8),
            text = "${highTemperature.value}${highTemperature.unit.symbol}",
            style = contentTextStyle,
            color = contentColor
        )

        DividerLine(modifier = then(dividerPadding))

        ArrowIcon(modifier = Modifier.rotate(180f), tint = contentColor, contentDescription = "low temperature is ${lowTemperature.value}")

        Text(
            modifier = Modifier.padding(start = dimensions.spacing8),
            text = "${lowTemperature.value}${lowTemperature.unit.symbol}",
            style = contentTextStyle,
            color = contentColor
        )
    }
}

@Composable
private fun ArrowIcon(tint: Color, contentDescription: String, modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier,
        painter = painterResource(R.drawable.icon_arrow_down),
        tint = tint,
        contentDescription = contentDescription,
    )
}

@Preview(showBackground = false, backgroundColor = 0xFF673AB7, showSystemUi = true)
@Composable
private fun TemperatureRangeRowPreview() {
    MyWeatherTheme(isDay = false) {
        TemperatureRange(
            hasABackground = false,
            highTemperature = WeatherValue(32, WeatherUnit.Celsius),
            lowTemperature = WeatherValue(20, WeatherUnit.Celsius),
        )
    }
}