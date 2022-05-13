package com.example.githubapiapp.core.presentation.composableState

data class TextFieldState(
    val text: String = "",
    val hasError: Boolean = false,
    val enabled: Boolean = true
)
