package com.example.githubapiapp.data.data_source.retrofit

import com.example.githubapiapp.domain.data_source.RepoFetcher
import com.example.githubapiapp.domain.data_source.retrofit.api.ApiGitHub
import com.example.githubapiapp.domain.model.dto.GitHubListResponseDto
import com.example.githubapiapp.domain.model.dto.UrlRequest
import retrofit2.Response

class RepoRetrofitDataSource(
    private val apiGitHub: ApiGitHub
) : RepoFetcher {

    override suspend fun fetchReposByUrl(urlRequest: UrlRequest): Response<GitHubListResponseDto> {
        return apiGitHub.fetchReposByUrl(urlRequest.url)
    }
}