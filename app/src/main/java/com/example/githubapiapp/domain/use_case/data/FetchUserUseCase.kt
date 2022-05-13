package com.example.githubapiapp.domain.use_case.data

import com.example.githubapiapp.domain.data_source.UserFetcher
import com.example.githubapiapp.domain.model.ui.FullUserUi
import com.example.githubapiapp.presentation.util.ext.toUi
import retrofit2.Response

class FetchUserUseCase(
    private val userFetcher: UserFetcher
) {

    suspend operator fun invoke(url: String): Response<FullUserUi> {
        return userFetcher.fetchUser(url).toUi()
    }
}
