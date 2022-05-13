package com.example.githubapiapp.presentation.screen.reposearch

import androidx.lifecycle.viewModelScope
import com.example.githubapiapp.core.presentation.base.BaseViewModel
import com.example.githubapiapp.core.util.pagination.DefaultPaginatorImpl
import com.example.githubapiapp.domain.model.dto.UrlRequest
import com.example.githubapiapp.domain.usecase.FetchReposUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class RepoSearchViewModel : BaseViewModel() {

    val uiState = RepoSearchUiState()
    abstract fun search()
    abstract fun loadNextRepos()
}

class RepoSearchViewModelImpl(
    private val fetchReposUseCase: FetchReposUseCase
) : RepoSearchViewModel() {

    private val urlRequest = UrlRequest()
    private val paginator = DefaultPaginatorImpl(
        initialKey = initialPage,
        onLoadUpdated = {
            uiState.lazyColumnState.value = uiState.lazyColumnState.value.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            urlRequest.page = nextPage
            fetchReposUseCase(urlRequest = urlRequest)
        },
        getNextKey = {
            uiState.lazyColumnState.value.page + 1
        },
        onError = {

        },
        onSuccess = { repos, newKey ->
            uiState.lazyColumnState.value = uiState.lazyColumnState.value.copy(
                searchResult = uiState.lazyColumnState.value.searchResult + repos,
                page = newKey,
                endReached = repos.isEmpty()
            )
        }
    )

    override fun search() {
        refreshUrlRequest()
        paginator.reset()
        loadNextRepos()
    }

    override fun loadNextRepos() {
        viewModelScope.launch(Dispatchers.IO) {
            paginator.loadNextItems()
        }
    }

    private fun refreshUrlRequest() {
        urlRequest.query = uiState.searchState.value.text
        urlRequest.page = initialPage
        urlRequest.sorting = uiState.selectedSorting.value
    }

    private companion object {
        const val initialPage = 1
    }
}
