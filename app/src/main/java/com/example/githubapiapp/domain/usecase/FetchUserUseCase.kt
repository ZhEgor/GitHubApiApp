package com.example.githubapiapp.domain.usecase

import com.example.githubapiapp.domain.datasource.UserFetcher
import com.example.githubapiapp.domain.model.ui.FullUserUi
import com.example.githubapiapp.presentation.util.ext.toUi

class FetchUserUseCase(
    private val userFetcher: UserFetcher
) {

    suspend operator fun invoke(url: String): FullUserUi? {
        return userFetcher.fetchUser(url).toUi().body()
    }
}
