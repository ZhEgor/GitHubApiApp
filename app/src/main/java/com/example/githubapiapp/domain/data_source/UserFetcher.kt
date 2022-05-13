package com.example.githubapiapp.domain.data_source

import com.example.githubapiapp.domain.model.dto.FullUserDto
import retrofit2.Response

interface UserFetcher {

    suspend fun fetchUser(url: String): Response<FullUserDto>
}
