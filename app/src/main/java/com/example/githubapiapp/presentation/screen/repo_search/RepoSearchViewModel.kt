package com.example.githubapiapp.presentation.screen.repo_search

import androidx.lifecycle.viewModelScope
import com.example.githubapiapp.core.presentation.base.BaseViewModel
import com.example.githubapiapp.core.util.pagination.DefaultPaginatorImpl
import com.example.githubapiapp.domain.model.dto.UrlRequest
import com.example.githubapiapp.domain.use_case.screen.RepoSearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class RepoSearchViewModel : BaseViewModel() {

    val uiState = RepoSearchUiState()
    val state = RepoSearchState()
    abstract fun onEvent(event: RepoSearchEvent)
}

class RepoSearchViewModelImpl(
    private val useCase: RepoSearchUseCase
) : RepoSearchViewModel() {

    private val urlRequest = UrlRequest()
    private val paginator = DefaultPaginatorImpl(
        initialKey = state.page.value,
        onLoadUpdated = {
            state.isLoading.value = it
        },
        onRequest = { nextPage ->
            urlRequest.page = nextPage
            useCase.fetchReposUseCase(urlRequest = urlRequest)
        },
        getNextKey = {
            state.page.value + 1
        },
        onError = {

        },
        onSuccess = { repos, lastLoadedPage ->
            state.searchResult.value += repos
            state.page.value += lastLoadedPage
            state.endReached.value = repos.isEmpty()
        }
    )

    init {
        loadRepos()
    }

    private fun loadRepos() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = useCase.fetchReposUseCase(urlRequest = urlRequest)
            if (response.isSuccessful) {
                response.body()?.let { state.searchResult.value = it }
            } else {
                // ToDo: show error dialog
            }
        }
    }

    private fun refreshUrlRequest() {
        urlRequest.query = uiState.searchState.value.text
        urlRequest.page = 1
        urlRequest.sorting = uiState.selectedSorting.value
    }

    override fun onEvent(event: RepoSearchEvent) {
        when (event) {
            is RepoSearchEvent.Search -> {
                refreshUrlRequest()
                loadRepos()
            }
            is RepoSearchEvent.LoadNextItems -> {
                viewModelScope.launch(Dispatchers.IO) {
                    paginator.loadNextItems()
                }
            }
        }
    }
}
