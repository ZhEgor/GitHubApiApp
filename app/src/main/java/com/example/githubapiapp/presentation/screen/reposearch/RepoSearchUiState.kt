package com.example.githubapiapp.presentation.screen.reposearch

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.githubapiapp.core.presentation.composableState.LazyColumnState
import com.example.githubapiapp.core.presentation.composableState.TextFieldState
import com.example.githubapiapp.domain.model.dto.SortBy

data class RepoSearchUiState(
    val searchState: MutableState<TextFieldState> = mutableStateOf(TextFieldState(text = "git+language:python")),
    val selectedSorting: MutableState<SortBy> = mutableStateOf(SortBy.STARS),
    val lazyColumnState: MutableState<LazyColumnState> = mutableStateOf(LazyColumnState())
)
