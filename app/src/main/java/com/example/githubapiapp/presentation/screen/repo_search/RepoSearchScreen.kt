package com.example.githubapiapp.presentation.screen.repo_search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.githubapiapp.R
import com.example.githubapiapp.core.presentation.components.NoResultStateCard
import com.example.githubapiapp.presentation.screen.repo_search.components.RepoListItem
import com.example.githubapiapp.presentation.screen.repo_search.components.SelectSorting
import com.example.githubapiapp.presentation.util.navigation.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun RepoSearchScreen(
    navController: NavController,
    viewModel: RepoSearchViewModel = getViewModel()
) {
    val uiState = viewModel.uiState
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = uiState.searchState.value.text,
            enabled = uiState.searchState.value.enabled,
            label = { Text(text = "Search and query field") },
            onValueChange = {
                uiState.searchState.value = uiState.searchState.value.copy(text = it)
            },
            trailingIcon = {
                if (uiState.searchState.value.text.isNotEmpty()) {
                    IconButton(onClick = {
                        uiState.searchState.value = uiState.searchState.value.copy(text = "")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Cancel,
                            contentDescription = "remove text"
                        )
                    }
                }
            },
            leadingIcon = {
                IconButton(
                    onClick = {
                        viewModel.onEvent(RepoSearchEvent.Search)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search by text"
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedLabelColor = MaterialTheme.colors.primaryVariant,
                focusedBorderColor = MaterialTheme.colors.primaryVariant,
                cursorColor = MaterialTheme.colors.primaryVariant
            ),
            singleLine = true
        )
        SelectSorting(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp), selectedSorting = uiState.selectedSorting
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp)
        ) {
            if (state.searchResult.value.isNotEmpty()) {
                items(state.searchResult.value.size) { position ->
                    if (position >= state.searchResult.value.size - 5 && !state.endReached.value && !state.isLoading.value) {
                        viewModel.onEvent(RepoSearchEvent.LoadNextItems)
                    }
                    RepoListItem(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colors.primaryVariant)
                        .clickable {
                            navController.navigate(route = Screen.RepoDetailsScreen.route)
                        },
                        repoUi = state.searchResult.value[position]
                    )
                }
                item {
                    if (state.isLoading.value) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            } else {
                item {
                    NoResultStateCard(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 160.dp),
                        text = stringResource(R.string.no_search_result_state)
                    )
                }
            }
        }
    }
}