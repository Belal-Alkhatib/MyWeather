package com.thechance.myweather.ui.screen.weatherOverview.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.colors
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.dimensions

@Composable
fun BlurredBackgroundBox(
    blurredBackgroundBoxSize: Dp,
    modifier: Modifier = Modifier,
    blurredBackgroundBoxSizePlus: Dp = dimensions.spaceZero,
    blurRadius: Dp = dimensions.blurRadius16,
    blurColor: Color = colors.blur,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(blurredBackgroundBoxSize + blurredBackgroundBoxSizePlus)
                .blur(
                    radiusX = blurRadius,
                    radiusY = blurRadius,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
        ) { Box(modifier = Modifier.fillMaxSize().background(color = blurColor, shape = CircleShape)) }

        content()
    }
}