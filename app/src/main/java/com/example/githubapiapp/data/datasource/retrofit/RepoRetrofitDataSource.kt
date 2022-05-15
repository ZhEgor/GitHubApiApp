package com.example.githubapiapp.data.datasource.retrofit

import com.example.githubapiapp.domain.datasource.RepoFetcher
import com.example.githubapiapp.domain.datasource.retrofit.api.ApiGitHub
import com.example.githubapiapp.domain.model.dto.GitHubListResponseDto
import com.example.githubapiapp.domain.model.dto.RepoDto
import com.example.githubapiapp.domain.model.dto.UrlRequest
import retrofit2.Response

class RepoRetrofitDataSource(
    private val apiGitHub: ApiGitHub
) : RepoFetcher {

    override suspend fun fetchReposByUrl(url: String): Response<GitHubListResponseDto> {
        return apiGitHub.fetchReposByUrl(url)
    }

    override suspend fun fetchRepoByUrl(url: String): Response<RepoDto> {
        return apiGitHub.fetchRepoByUrl(url)
    }
}