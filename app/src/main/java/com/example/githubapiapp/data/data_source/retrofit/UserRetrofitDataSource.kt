package com.example.githubapiapp.data.data_source.retrofit

import com.example.githubapiapp.domain.data_source.UserFetcher
import com.example.githubapiapp.domain.data_source.retrofit.api.ApiGitHub
import com.example.githubapiapp.domain.model.dto.FullUserDto
import retrofit2.Response

class UserRetrofitDataSource(
    private val apiGitHub: ApiGitHub
) : UserFetcher {

    override suspend fun fetchUser(url: String): Response<FullUserDto> {
        return apiGitHub.fetchUserByUrl(url)
    }
}
