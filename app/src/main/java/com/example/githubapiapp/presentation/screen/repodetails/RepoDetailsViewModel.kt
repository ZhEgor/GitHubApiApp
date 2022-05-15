package com.example.githubapiapp.presentation.screen.repodetails

import androidx.lifecycle.viewModelScope
import com.example.githubapiapp.core.presentation.base.BaseViewModel
import com.example.githubapiapp.domain.usecase.FetchRepoUseCase
import com.example.githubapiapp.domain.usecase.FetchUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class RepoDetailsViewModel : BaseViewModel() {

    val uiState = RepoDetailsUiState()
}

class RepoDetailsViewModelImpl(
    private val fetchUserUseCase: FetchUserUseCase,
    private val fetchRepoUseCase: FetchRepoUseCase,
    private val repoUrl: String,
    private val userUrl: String
) : RepoDetailsViewModel() {

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val deferredRepoUi = async {
                fetchRepoUseCase(repoUrl)
            }
            val deferredUserUi = async {
                fetchUserUseCase(userUrl)
            }
            uiState.repoUi.value = deferredRepoUi.await()
            uiState.userUi.value = deferredUserUi.await()
            uiState.hasLoaded.value = true
        }
    }
}
