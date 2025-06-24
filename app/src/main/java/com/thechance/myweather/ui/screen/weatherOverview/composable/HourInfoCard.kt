package com.thechance.myweather.ui.screen.weatherOverview.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.myweather.R
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.colors
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.dimensions

@Composable
fun HourInfoCard(
    modifier: Modifier = Modifier,
    weatherIconPainter: Painter,
    temperature: WeatherValue<Int>,
    hour: String
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        BorderedCard(
            modifier = Modifier
                .wrapContentSize()
                .graphicsLayer(clip = false)
        ) {

            Text(
                modifier = Modifier.padding(
                    start = dimensions.spacing26,
                    end = dimensions.spacing26,
                    top = dimensions.spacing62
                ),
                text = "${temperature.value}${temperature.unit}",
                style = MaterialTheme.typography.titleLarge,
                color = colors.text.primaryText
            )

            Text(
                modifier = Modifier.padding(
                    top = dimensions.spacing4,
                    bottom = dimensions.spacing16
                ),
                text = hour,
                style = MaterialTheme.typography.titleSmall,
                color = colors.text.secondaryText
            )
        }

        BlurredBackgroundBox(
            modifier = Modifier.align(Alignment.TopCenter).offset(y = -dimensions.spacing12),
            blurredBackgroundBoxSize = dimensions.imageHeight58,
            blurColor = colors.blur.copy(alpha = .08f)
        ) {
            Image(
                modifier = Modifier
                    .height(dimensions.imageHeight58)
                    .width(dimensions.imageWidth64),
                painter = weatherIconPainter,
                contentDescription = temperature.value.toString(),
            )
        }
    }

}

@Preview
@Composable
private fun HourInfoCardPreview() {
    HourInfoCard(
        weatherIconPainter = painterResource(R.drawable.image_day_code_1),
        temperature = WeatherValue(0, "C"),
        hour = "11:00"
    )
}