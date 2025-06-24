package com.thechance.myweather.ui.screen.weatherOverview.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.dimensions
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.colors

@Composable
fun BorderedCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(dimensions.radius24)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(color = colors.background.onBackgroundPrimary, shape = shape)
            .border(width = dimensions.borderWidth, color = colors.border, shape = shape),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }
}