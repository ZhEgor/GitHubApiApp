package com.example.githubapiapp.presentation.screen.repo_search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.githubapiapp.core.presentation.composableState.TextFieldState
import com.example.githubapiapp.domain.model.dto.SortBy
import com.example.githubapiapp.domain.model.ui.RepoUi

data class RepoSearchState(
    val isLoading: MutableState<Boolean> = mutableStateOf(false),
    val endReached: MutableState<Boolean> = mutableStateOf(false),
    val page: MutableState<Int> = mutableStateOf(1),
    val position: MutableState<Int> = mutableStateOf(1),
    val searchResult: MutableState<List<RepoUi>> = mutableStateOf(emptyList())
)

data class RepoSearchUiState(
    val searchState: MutableState<TextFieldState> = mutableStateOf(TextFieldState(text = "git+language:python")),
    val selectedSorting: MutableState<SortBy> = mutableStateOf(SortBy.STARS),
)
