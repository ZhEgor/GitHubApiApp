package com.example.githubapiapp.di.module

import com.example.githubapiapp.domain.usecase.FetchReposUseCase
import com.example.githubapiapp.domain.usecase.FetchUserUseCase
import org.koin.dsl.module

val useCasesModule = module {

    factory { FetchReposUseCase(get()) }
    factory { FetchUserUseCase(get()) }

}