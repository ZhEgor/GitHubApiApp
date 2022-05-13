package com.example.githubapiapp.domain.use_case.data

import com.example.githubapiapp.domain.data_source.RepoFetcher
import com.example.githubapiapp.domain.model.dto.UrlRequest
import com.example.githubapiapp.domain.model.ui.RepoUi
import com.example.githubapiapp.presentation.util.ext.toUi
import retrofit2.Response

class FetchReposUseCase(
    private val repoFetcher: RepoFetcher
) {

    suspend operator fun invoke(urlRequest: UrlRequest): Response<List<RepoUi>> {
        return repoFetcher.fetchReposByUrl(urlRequest).toUi()
    }
}
