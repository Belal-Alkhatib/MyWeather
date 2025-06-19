package com.thechance.myweather.ui.screen.weatherOverview

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.thechance.myweather.R
import com.thechance.myweather.ui.screen.weatherOverview.composable.BlurredBackgroundBox
import com.thechance.myweather.ui.screen.weatherOverview.composable.BorderedCard
import com.thechance.myweather.ui.screen.weatherOverview.composable.DayInfoCard
import com.thechance.myweather.ui.screen.weatherOverview.composable.HourInfoCard
import com.thechance.myweather.ui.screen.weatherOverview.composable.MyWeatherCircularProgressIndicator
import com.thechance.myweather.ui.screen.weatherOverview.composable.SpacerVertically
import com.thechance.myweather.ui.screen.weatherOverview.composable.TemperatureRange
import com.thechance.myweather.ui.screen.weatherOverview.composable.WeatherDetailCard
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.CurrentWeatherInfoUiState
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeatherDetailItemUiState
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeatherOverviewUiState
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeatherOverviewViewModel
import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeekWeatherItemUiState
import com.thechance.myweather.ui.screen.weatherOverview.util.getIconResourceByWeatherCode
import com.thechance.myweather.ui.screen.weatherOverview.util.getWeatherDetailIconResByTitle
import com.thechance.myweather.ui.screen.weatherOverview.util.getWeatherTitleResourceByWeatherTitle
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.colors
import com.thechance.myweather.ui.theme.MyWeatherAppTheme.dimensions
import com.thechance.myweather.ui.theme.MyWeatherTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherOverviewViewModel = koinViewModel<WeatherOverviewViewModel>()
) {
    val state by viewModel.state.collectAsState()

    MyWeatherTheme(isDay = state.isDay) {

        AnimatedVisibility (
            visible = state.baseUiState.isLoading,
            enter = fadeIn(tween()) ,
            exit = fadeOut(tween(500)) + scaleOut(),
            label = "loading screen"
        ){
            MyWeatherCircularProgressIndicator(modifier = Modifier.statusBarsPadding())
        }
        AnimatedVisibility (
            visible = !state.baseUiState.isLoading && state.baseUiState.errorMessage.isNullOrEmpty(),
            enter = fadeIn(tween(900)) + scaleIn(animationSpec = spring(stiffness = Spring.StiffnessMedium)) ,
            exit = fadeOut(tween()),
            label = "home screen content"
        ){
            HomeScreenContent(modifier = modifier, state = state)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreenContent(modifier: Modifier = Modifier, state: WeatherOverviewUiState) {
    val listState = rememberLazyListState()

    val shouldStartAnimation by remember {
        derivedStateOf { listState.firstVisibleItemIndex >= 1 }
    }

    LazyColumn(
        modifier = modifier.fillMaxSize().background(brush = colors.background.backgroundBrush),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        contentPadding = PaddingValues(top = dimensions.spacing48, bottom = dimensions.spacing24),
        state = listState
    ) {

        item {
            LocationInfo(
                modifier = Modifier.padding(vertical = dimensions.spacing8),
                cityName = state.cityName
            )
        }

        item {
            CurrentWeatherSection(
                currentWeatherState = state.currentWeatherInfoUiState,
                isDay = state.isDay,
                shouldStartAnimation = shouldStartAnimation
            )
        }

        item {
            SpacerVertically(space = dimensions.spacing24)
            WeatherDetailRow(
                modifier = Modifier.padding(horizontal = dimensions.spacing12),
                items = state.weatherDetails.take(3)
            )

            SpacerVertically(space = dimensions.spacing6)
            WeatherDetailRow(
                modifier = Modifier.padding(horizontal = dimensions.spacing12),
                items = state.weatherDetails.takeLast(3)
            )
        }

        item {
            TitledSection(
                modifier = Modifier.padding(bottom = dimensions.spacing12),
                title = stringResource(R.string.today)
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(dimensions.spacing12),
                    contentPadding = PaddingValues(horizontal = dimensions.spacing12)
                ) {
                    items(items = state.todayWeather,) { weather ->
                        HourInfoCard(
                            temperature = weather.temperature,
                            hour = weather.hour,
                            weatherIconPainter = painterResource(
                                getIconResourceByWeatherCode(
                                    weather.imageCode,
                                    state.isDay
                                )
                            )
                        )
                    }
                }
            }
        }

        item {
            TitledSection(title = stringResource(R.string.next_7_days)) {
                Next7DaysCard(
                    modifier = Modifier.padding(horizontal = dimensions.spacing12),
                    next7DaysWeather = state.weeklyWeather,
                    isDay = state.isDay,
                )
            }
        }
    }
}

@Composable
private fun LocationInfo(cityName: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_location),
            tint = colors.gray,
            contentDescription = cityName
        )

        Text(
            modifier = Modifier.padding(start = dimensions.spacing4),
            text = cityName,
            style = MaterialTheme.typography.bodyLarge,
            color = colors.gray
        )
    }
}

@Composable
private fun CurrentWeatherSection(
    currentWeatherState: CurrentWeatherInfoUiState,
    isDay: Boolean,
    shouldStartAnimation: Boolean,
) {

    val animatedParentBoxHeight by
    animateDpAsState(
        targetValue = if (shouldStartAnimation) 180.dp else 386.dp,
        animationSpec = tween(700)
    )

    val animatedImageHeight by animateDpAsState(
        targetValue = if (shouldStartAnimation) dimensions.imageHeight112 else dimensions.imageHeight220,
        animationSpec = tween(700)
    )
    val animatedImageWidth by animateDpAsState(
        targetValue = if (shouldStartAnimation) dimensions.imageWidth124 else dimensions.imageWidth227,
        animationSpec = tween(700)
    )

    val start = -1f; val center = 0f; val end = 1f

    val animatedImageAlignmentHorizontally by
    animateFloatAsState(
        targetValue = if (shouldStartAnimation) start else center,
        animationSpec = tween(700)
    )

    val animatedImageAlignmentVertically by
    animateFloatAsState(
        targetValue = if (shouldStartAnimation) center else start,
        animationSpec = tween(700)
    )

    val animatedColumnAlignmentHorizontally by animateFloatAsState(
        targetValue = if (shouldStartAnimation) end else center,
        animationSpec = tween(700)
    )

    val animatedColumnAlignmentVertically by animateFloatAsState(
        targetValue = if (shouldStartAnimation) center else end,
        animationSpec = tween(700)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(animatedParentBoxHeight)
            .padding(start = dimensions.spacing12),
    ) {

        Box(
            modifier = Modifier.align(
                BiasAlignment(
                    horizontalBias = animatedImageAlignmentHorizontally,
                    verticalBias = animatedImageAlignmentVertically
                )
            )
        ) {
            BlurredBackgroundBox(
                modifier = Modifier.align(Alignment.CenterStart),
                blurredBackgroundBoxSize = animatedImageHeight,
                blurredBackgroundBoxSizePlus = dimensions.spacing12,
                blurRadius = dimensions.blurRadius128
            ){
                Image(
                    modifier = Modifier.height(animatedImageHeight).width(animatedImageWidth),
                    painter = painterResource(
                        getIconResourceByWeatherCode(currentWeatherState.imageCode, isDay)
                    ),
                    contentDescription = currentWeatherState.description,
                    alignment = Alignment.CenterStart
                )
            }
        }

        Column(
            modifier = Modifier
                .align(
                    BiasAlignment(
                        horizontalBias = animatedColumnAlignmentHorizontally,
                        verticalBias = animatedColumnAlignmentVertically
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = dimensions.spacing12),
                text = "${currentWeatherState.temperature.value}${currentWeatherState.temperature.unit.symbol}",
                style = MaterialTheme.typography.displayLarge,
                color = colors.text.secondaryText
            )

            Text(
                modifier = Modifier.padding(bottom = dimensions.spacing12).fillMaxWidth(.5f),
                text = currentWeatherState.description,
                style = MaterialTheme.typography.bodyLarge,
                color = colors.text.tertiaryText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            TemperatureRange(
                modifier = Modifier,
                hasABackground = true,
                highTemperature = currentWeatherState.highTemperature,
                lowTemperature = currentWeatherState.lowTemperature,
            )
        }
    }
}

@Composable
private fun WeatherDetailRow(items: List<WeatherDetailItemUiState>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensions.spacing6),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { detail ->
            WeatherDetailCard(
                modifier = Modifier.weight(1f),
                icon = painterResource(getWeatherDetailIconResByTitle(detail.title)),
                value = detail.value,
                label = stringResource(getWeatherTitleResourceByWeatherTitle(detail.title)),
            )
        }
    }
}

@Composable
private fun TitledSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = dimensions.spacing12,
                    end = dimensions.spacing12,
                    top = dimensions.spacing24,
                    bottom = dimensions.spacing12
                ),
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = colors.text.primaryText
        )

        content()
    }
}

@Composable
private fun Next7DaysCard(
    next7DaysWeather: List<WeekWeatherItemUiState>,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    BorderedCard(modifier = modifier) {
        next7DaysWeather.forEachIndexed { index, todayWeather ->
            DayInfoCard(
                day = todayWeather.dayOfWeek,
                weatherImage = painterResource(
                    getIconResourceByWeatherCode(code = todayWeather.imageCode, isDay = isDay)
                ),
                todayHighTemperature = todayWeather.highTemperature,
                todayLowTemperature = todayWeather.lowTemperature,
                isBottomDividerLineVisible = index != next7DaysWeather.lastIndex
            )
        }
    }
}