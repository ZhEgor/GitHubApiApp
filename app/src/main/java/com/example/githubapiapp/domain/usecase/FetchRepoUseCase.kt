package com.example.githubapiapp.domain.usecase

import com.example.githubapiapp.domain.datasource.RepoFetcher
import com.example.githubapiapp.domain.model.ui.RepoUi
import com.example.githubapiapp.presentation.util.ext.toUi

class FetchRepoUseCase(
    private val repoFetcher: RepoFetcher
) {

    suspend operator fun invoke(url: String): RepoUi? {
        return repoFetcher.fetchRepoByUrl(url).toUi().body()
    }
}
