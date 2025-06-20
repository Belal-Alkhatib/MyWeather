package com.thechance.myweather.app.di

import com.thechance.myweather.domain.usecase.GetWeatherUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::GetWeatherUseCase)
}
