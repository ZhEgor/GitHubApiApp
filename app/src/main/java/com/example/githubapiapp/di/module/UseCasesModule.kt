package com.example.githubapiapp.di.module

import com.example.githubapiapp.domain.use_case.data.FetchReposUseCase
import com.example.githubapiapp.domain.use_case.data.FetchUserUseCase
import com.example.githubapiapp.domain.use_case.screen.RepoDetailsUseCase
import com.example.githubapiapp.domain.use_case.screen.RepoSearchUseCase
import org.koin.dsl.module

val useCasesModule = module {

    // Screens
    factory { RepoSearchUseCase(get()) }
    factory { RepoDetailsUseCase(get()) }

    // Data
    factory { FetchReposUseCase(get()) }
    factory { FetchUserUseCase(get()) }

}