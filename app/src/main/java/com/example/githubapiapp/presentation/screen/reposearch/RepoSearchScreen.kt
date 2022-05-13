package com.example.githubapiapp.presentation.screen.reposearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.githubapiapp.presentation.screen.reposearch.components.LazyColumnRepo
import com.example.githubapiapp.presentation.screen.reposearch.components.SearchField
import com.example.githubapiapp.presentation.screen.reposearch.components.SelectSorting
import com.example.githubapiapp.presentation.util.navigation.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun RepoSearchScreen(
    navController: NavController,
    viewModel: RepoSearchViewModel = getViewModel()
) {
    val uiState = viewModel.uiState

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
                route = Screen.RepoDetailsScreen.withArgs(repoUi.url, repoUi.owner.url)
            )
        }
    }
}