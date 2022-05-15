package com.example.githubapiapp.domain.usecase

import com.example.githubapiapp.domain.datasource.RepoFetcher
import com.example.githubapiapp.domain.model.dto.UrlRequest
import com.example.githubapiapp.domain.model.ui.RepoUi
import com.example.githubapiapp.presentation.util.ext.toUi

class FetchReposUseCase(
    private val repoFetcher: RepoFetcher
) {

    suspend operator fun invoke(url: String): List<RepoUi>? {
        return repoFetcher.fetchReposByUrl(url).toUi().body()
    }
}
