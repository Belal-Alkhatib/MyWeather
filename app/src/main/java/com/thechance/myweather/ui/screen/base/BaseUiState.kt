package com.thechance.myweather.ui.screen.base

data class BaseUiState(
    val isLoading: Boolean = false,
    val errorMessage: ErrorMessageUiState = ErrorMessageUiState()
)

data class ErrorMessageUiState(
    val title: String? = null,
    val description: String = ""
)
