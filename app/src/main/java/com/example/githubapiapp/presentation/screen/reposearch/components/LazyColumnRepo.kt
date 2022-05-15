package com.example.githubapiapp.presentation.screen.reposearch.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.githubapiapp.R
import com.example.githubapiapp.core.presentation.components.StateCard
import com.example.githubapiapp.core.presentation.composableState.LazyColumnState
import com.example.githubapiapp.domain.model.ui.RepoUi

@Composable
fun LazyColumnRepo(
    modifier: Modifier = Modifier,
    lazyColumnState: MutableState<LazyColumnState>,
    onPaging: () -> Unit,
    onClick: (RepoUi) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        if (lazyColumnState.value.isSearching) {
            items(6) {
                ShimmeringRepoListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colors.primaryVariant),
                )
            }
        } else if (lazyColumnState.value.searchResult.isNotEmpty()) {
            items(lazyColumnState.value.searchResult.size) { position ->
                if (
                    position >= lazyColumnState.value.searchResult.size - 5 &&
                    !lazyColumnState.value.endReached &&
                    !lazyColumnState.value.isPaging
                ) {
                    onPaging()
                }
                RepoListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colors.primaryVariant),
                    repoUi = lazyColumnState.value.searchResult[position],
                    onClick = onClick
                )
            }
            item {
                if (lazyColumnState.value.isPaging) {
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
                StateCard(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 160.dp),
                    text = stringResource(R.string.no_search_result_state),
                    painter = painterResource(id = R.drawable.ic_no_search_result),
                    contentDescription = stringResource(R.string.number_of_watchers_description)
                )
            }
        }
    }
}