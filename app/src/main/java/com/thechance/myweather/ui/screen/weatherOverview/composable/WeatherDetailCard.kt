package com.thechance.myweather.ui.screen.weatherOverview.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.myweather.R
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.theme.MyWeatherAppTheme
import com.thechance.myweather.ui.theme.MyWeatherTheme

@Composable
fun WeatherDetailCard(
    icon: Painter,
    value: WeatherValue<Int>,
    label: String,
    modifier: Modifier = Modifier,
) {
    val colors = MyWeatherAppTheme.colors
    val dimensions = MyWeatherAppTheme.dimensions

    BorderedCard(modifier = modifier) {

        Icon(
            modifier = Modifier.padding(top = dimensions.spacing16),
            painter = icon,
            contentDescription = "$label is $value",
            tint = colors.skyblue
        )

        Text(
            modifier = Modifier.padding(top = dimensions.spacing8, bottom = dimensions.spacing2),
            text = "${value.value}${value.unit}",
            style = MaterialTheme.typography.titleLarge,
            color = colors.text.primaryText
        )

        Text(
            modifier = Modifier.padding(bottom = dimensions.spacing16),
            text = label,
            style = MaterialTheme.typography.titleSmall,
            color = colors.text.secondaryText
        )
    }
}

@Preview
@Composable
private fun WeatherDetailCardPreview() {
    MyWeatherTheme(isDay = false) {
        WeatherDetailCard(
            icon = painterResource(R.drawable.icon_fast_wind),
            value = WeatherValue(14, "Km"),
            label = "Wind",
        )
    }
}