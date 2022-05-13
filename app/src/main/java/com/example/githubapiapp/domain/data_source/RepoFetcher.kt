package com.example.githubapiapp.domain.data_source

import com.example.githubapiapp.domain.model.dto.GitHubListResponseDto
import com.example.githubapiapp.domain.model.dto.UrlRequest
import retrofit2.Response

interface RepoFetcher {

    suspend fun fetchReposByUrl(urlRequest: UrlRequest): Response<GitHubListResponseDto>
}
