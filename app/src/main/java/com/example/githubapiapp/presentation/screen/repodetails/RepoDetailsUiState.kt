package com.example.githubapiapp.presentation.screen.repodetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.githubapiapp.domain.model.ui.FullUserUi
import com.example.githubapiapp.domain.model.ui.RepoUi

data class RepoDetailsUiState(
    val hasLoaded: MutableState<Boolean> = mutableStateOf(false),
    val repoUi: MutableState<RepoUi?> = mutableStateOf(null),
    val userUi: MutableState<FullUserUi?> = mutableStateOf(null)
)
