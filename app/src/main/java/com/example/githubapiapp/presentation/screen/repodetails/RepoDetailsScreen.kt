package com.example.githubapiapp.presentation.screen.repodetails

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.githubapiapp.R
import com.example.githubapiapp.core.presentation.components.StateCard

@Composable
fun RepoDetailsScreen(viewModel: RepoDetailsViewModel) {
    val uiState = viewModel.uiState
    if (uiState.hasLoaded.value && uiState.repoUi.value != null && uiState.userUi.value != null) {
        Text(text = uiState.repoUi.value!!.name)
        Text(text = uiState.userUi.value!!.login)
    } else {
        StateCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 160.dp),
            text = stringResource(R.string.wait_until_it_loads_state),
            painter = painterResource(id = R.drawable.ic_wait),
            contentDescription = stringResource(R.string.wait_until_it_loads_description)
        )
    }
}