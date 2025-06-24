package com.thechance.myweather.ui.screen.weatherOverview.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.myweather.R
import com.thechance.myweather.domain.entity.WeatherValue
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.colors
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.dimensions


@Composable
fun DayInfoCard(
    day: String,
    weatherImage: Painter,
    modifier: Modifier = Modifier,
    todayHighTemperature: WeatherValue<String>,
    todayLowTemperature: WeatherValue<String>,
    isBottomDividerLineVisible: Boolean = true
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(colors.background.onBackgroundPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensions.spacing16, vertical = dimensions.spacing8),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.weight(1f),
                text = day,
                style = MaterialTheme.typography.bodyMedium,
                color = colors.text.tertiaryText
            )

            BlurredBackgroundBox(
                modifier = Modifier.weight(1f),
                blurredBackgroundBoxSize = dimensions.imageHeight58,
                blurColor = colors.blur.copy(alpha = .08f)
            ) {
                Image(
                    modifier = Modifier.height(dimensions.imageSize45),
                    painter = weatherImage,
                    contentDescription = todayHighTemperature.toString(),
                )
            }

            TemperatureRange(
                modifier = Modifier.weight(1f),
                highTemperature = todayHighTemperature,
                lowTemperature = todayLowTemperature,
                contentColor = colors.text.secondaryText,
                contentTextStyle = MaterialTheme.typography.bodySmall,
                dividerPadding = PaddingValues(
                    vertical = dimensions.spacing1,
                    horizontal = dimensions.spacing4
                )
            )
        }

        AnimatedVisibility(isBottomDividerLineVisible) {
            DividerLine(
                modifier = modifier
                    .fillMaxWidth()
                    .height(dimensions.dividerLineWidth),
                color = colors.border
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true,
    device = "spec:width=800px,height=800px,dpi=240"
)
@Composable
private fun DayInfoCardPreview() {
    DayInfoCard(
        day = "Monday",
        weatherImage = painterResource(R.drawable.image_day_code_45),
        todayHighTemperature = WeatherValue("32", "C"),
        todayLowTemperature = WeatherValue("20", "C"),
    )
}