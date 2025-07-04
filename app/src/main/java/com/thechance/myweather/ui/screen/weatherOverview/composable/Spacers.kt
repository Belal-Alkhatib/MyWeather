package com.thechance.myweather.ui.screen.weatherOverview.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun SpacerVertically(space: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.height(space))
}