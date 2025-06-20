package com.thechance.myweather.app.di

import com.thechance.myweather.ui.screen.weatherOverview.stateHolder.WeatherOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::WeatherOverviewViewModel)
}