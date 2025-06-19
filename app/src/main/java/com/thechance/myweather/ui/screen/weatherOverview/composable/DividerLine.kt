package com.thechance.myweather.ui.screen.weatherOverview.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.dimensions
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.colors
import com.thechance.myweather.ui.theme.MyWeatherTheme

@Composable
fun DividerLine(
    modifier: Modifier = Modifier,
    color: Color = colors.divider,
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .width(dimensions.dividerLineWidth)
            .background(color = color, shape = RoundedCornerShape(percent = 50))
    )
}

@Preview(device = "id:pixel_5", showSystemUi = true, showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun DividerLinePreview() {
    MyWeatherTheme(true) {
        DividerLine()
    }
}