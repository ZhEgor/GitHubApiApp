package com.example.githubapiapp.presentation.screen.repo_search

sealed class RepoSearchEvent {
    object LoadNextItems : RepoSearchEvent()
    object Search : RepoSearchEvent()
}

sealed class RepoSearchUiEvent {
    object ShowError : RepoSearchUiEvent()
}