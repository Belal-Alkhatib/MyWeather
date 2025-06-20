package com.thechance.myweather.ui.screen.weatherOverview.composable

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.thechance.myweather.R
import com.thechance.myweather.ui.MainActivity
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.colors
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.dimensions
import com.thechance.myweather.ui.theme.MyWeatherTheme

@Composable
fun ErrorMessageScreen(
    title: String,
    description: String,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
    errorImagePainter: Painter = painterResource(R.drawable.default_error_image)
) {

    MyWeatherTheme(isDay = true) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(colors.background.onBackgroundPrimary)
                .padding(horizontal = dimensions.spacing12, vertical = dimensions.spacing48),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = errorImagePainter,
                contentDescription = title
            )

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = dimensions.spacing24, bottom = dimensions.spacing8),
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = colors.text.primaryText
            )

            Text(
                modifier = Modifier.fillMaxWidth(.8f),
                text = description,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = colors.text.tertiaryText
            )

            SpacerVertically(dimensions.spacing32)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensions.buttonHeight)
                    .clickable { onRetryClick() }
                    .background(colors.skyblue, shape = RoundedCornerShape(dimensions.radius24)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = stringResource(R.string.retry),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }
        }
    }
}