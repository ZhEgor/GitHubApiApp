package com.example.githubapiapp.presentation.screen.repodetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.example.githubapiapp.presentation.screen.repodetails.components.RepoDetails
import com.example.githubapiapp.presentation.screen.repodetails.components.ShimmeringRepoDetails
import com.example.githubapiapp.presentation.screen.repodetails.components.ShimmeringUserDetails
import com.example.githubapiapp.presentation.screen.repodetails.components.UserDetails

@Composable
fun RepoDetailsScreen(viewModel: RepoDetailsViewModel) {
    val uiState = viewModel.uiState
    val uriHandler = LocalUriHandler.current

    if (uiState.hasLoaded.value && uiState.repoUi.value != null && uiState.userUi.value != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            UserDetails(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = MaterialTheme.colors.primary)
                    .padding(16.dp),
                userUi = viewModel.uiState.userUi.value!!
            ) { url ->
                uriHandler.openUri(url)
            }
            RepoDetails(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = MaterialTheme.colors.secondary)
                    .padding(16.dp),
                repoUi = viewModel.uiState.repoUi.value!!
            ) { url ->
                uriHandler.openUri(url)
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ShimmeringUserDetails(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = MaterialTheme.colors.primary)
                    .padding(16.dp),
            )
            ShimmeringRepoDetails(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = MaterialTheme.colors.secondary)
                    .padding(16.dp)
            )
        }
    }
}