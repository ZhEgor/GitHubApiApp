package com.example.githubapiapp.core.presentation.composableState

import com.example.githubapiapp.domain.model.ui.RepoUi

data class LazyColumnState(
    val isLoading: Boolean = false,
    val endReached: Boolean = false,
    val page: Int = 1,
    val searchResult: List<RepoUi> = emptyList()
)
