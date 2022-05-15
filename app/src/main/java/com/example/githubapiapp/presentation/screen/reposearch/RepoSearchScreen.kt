package com.example.githubapiapp.presentation.screen.reposearch

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.githubapiapp.core.presentation.components.ErrorDialog
import com.example.githubapiapp.presentation.screen.reposearch.components.LazyColumnRepo
import com.example.githubapiapp.presentation.screen.reposearch.components.SearchField
import com.example.githubapiapp.presentation.screen.reposearch.components.SelectSorting
import com.example.githubapiapp.presentation.util.ext.replaceSlash
import com.example.githubapiapp.presentation.util.navigation.Screen
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel

@Composable
fun RepoSearchScreen(
    navController: NavController,
    viewModel: RepoSearchViewModel = getViewModel()
) {
    val uiState = viewModel.uiState
    val isErrorDialogActive = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        viewModel.uiEventFlow.collectLatest { event ->
            when (event) {
                is RepoSearchUiEvent.ShowErrorDialog -> {
                    isErrorDialogActive.value = true
                }
            }
        }
    }
    if (isErrorDialogActive.value) {
        ErrorDialog(
            modifier = Modifier
                .width(300.dp)
                .wrapContentHeight()
                .padding(8.dp),
            isDialogActive = isErrorDialogActive
        ) {
            viewModel.search()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchField(
            modifier = Modifier.fillMaxWidth(),
            searchState = uiState.searchState,
        ) {
            viewModel.search()
        }
        SelectSorting(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            selectedSorting = uiState.selectedSorting
        ) {
            viewModel.search()
        }
        LazyColumnRepo(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp),
            lazyColumnState = uiState.lazyColumnState,
            onPaging = {
                viewModel.loadNextRepos()
            }
        ) { repoUi ->
            navController.navigate(
                route = Screen.RepoDetailsScreen.withArgs(
                    repoUi.url.replaceSlash(),
                    repoUi.owner.url.replaceSlash()
                )
            )
        }
    }
}