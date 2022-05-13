package com.example.githubapiapp.domain.data_source.retrofit.api

import com.example.githubapiapp.domain.model.dto.FullUserDto
import com.example.githubapiapp.domain.model.dto.GitHubListResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiGitHub {

    @GET
    suspend fun fetchReposByUrl(@Url url: String): Response<GitHubListResponseDto>

    @GET
    suspend fun fetchUserByUrl(@Url url: String): Response<FullUserDto>
}
