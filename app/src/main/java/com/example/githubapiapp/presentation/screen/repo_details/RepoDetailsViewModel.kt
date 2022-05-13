package com.example.githubapiapp.presentation.screen.repo_details

import com.example.githubapiapp.core.presentation.base.BaseViewModel
import com.example.githubapiapp.domain.use_case.screen.RepoDetailsUseCase

abstract class RepoDetailsViewModel : BaseViewModel() {

}

class RepoDetailsViewModelImpl(
    private val useCase: RepoDetailsUseCase
) : RepoDetailsViewModel() {

}
