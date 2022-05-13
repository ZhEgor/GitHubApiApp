package com.example.githubapiapp.di.module

import com.example.githubapiapp.presentation.screen.repodetails.RepoDetailsViewModel
import com.example.githubapiapp.presentation.screen.repodetails.RepoDetailsViewModelImpl
import com.example.githubapiapp.presentation.screen.reposearch.RepoSearchViewModel
import com.example.githubapiapp.presentation.screen.reposearch.RepoSearchViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel<RepoSearchViewModel> { RepoSearchViewModelImpl(get()) }
    viewModel<RepoDetailsViewModel> { params ->
        RepoDetailsViewModelImpl(
            get(), get(),
            repoUrl = params[0],
            userUrl = params[1]
        )
    }
}