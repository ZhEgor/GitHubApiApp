package com.example.githubapiapp.domain.datasource

import com.example.githubapiapp.domain.model.dto.GitHubListResponseDto
import com.example.githubapiapp.domain.model.dto.RepoDto
import com.example.githubapiapp.domain.model.dto.UrlRequest
import retrofit2.Response

interface RepoFetcher {

    suspend fun fetchReposByUrl(url: String): Response<GitHubListResponseDto>
    suspend fun fetchRepoByUrl(url: String): Response<RepoDto>
}
