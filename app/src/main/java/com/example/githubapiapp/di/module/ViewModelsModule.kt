package com.example.githubapiapp.di.module

import com.example.githubapiapp.presentation.screen.repo_details.RepoDetailsViewModel
import com.example.githubapiapp.presentation.screen.repo_details.RepoDetailsViewModelImpl
import com.example.githubapiapp.presentation.screen.repo_search.RepoSearchViewModel
import com.example.githubapiapp.presentation.screen.repo_search.RepoSearchViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {


    viewModel<RepoSearchViewModel> { RepoSearchViewModelImpl(get()) }
    viewModel<RepoDetailsViewModel> { RepoDetailsViewModelImpl(get()) }
//    viewModel<WordListViewModel> { parameters -> WordListViewModelImpl(category = parameters.get(), get()) }

}