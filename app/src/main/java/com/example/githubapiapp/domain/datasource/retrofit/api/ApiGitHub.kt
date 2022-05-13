package com.example.githubapiapp.domain.datasource.retrofit.api

import com.example.githubapiapp.domain.model.dto.FullUserDto
import com.example.githubapiapp.domain.model.dto.GitHubListResponseDto
import com.example.githubapiapp.domain.model.dto.RepoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiGitHub {

    @GET
    suspend fun fetchReposByUrl(@Url url: String): Response<GitHubListResponseDto>

    @GET
    suspend fun fetchRepoByUrl(@Url url: String): Response<RepoDto>

    @GET
    suspend fun fetchUserByUrl(@Url url: String): Response<FullUserDto>
}
