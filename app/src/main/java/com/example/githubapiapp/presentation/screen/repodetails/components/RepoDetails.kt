package com.example.githubapiapp.presentation.screen.repodetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Public
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubapiapp.R
import com.example.githubapiapp.core.presentation.components.LabelToTextField
import com.example.githubapiapp.domain.model.ui.RepoUi

@Composable
fun RepoDetails(
    modifier: Modifier = Modifier,
    repoUi: RepoUi,
    onFollowLink: (String) -> Unit
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = repoUi.name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            IconButton(
                modifier = Modifier.padding(horizontal = 8.dp),
                onClick = {
                    onFollowLink(repoUi.htmlUrl)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Public,
                    contentDescription = stringResource(R.string.open_in_browser_description)
                )
            }
        }
        LabelToTextField(label = stringResource(R.string.language_label), text = repoUi.language)
        LabelToTextField(
            label = stringResource(R.string.last_modified_label),
            text = repoUi.updatedAt
        )
        LabelToTextField(
            label = stringResource(R.string.date_of_creation_label),
            text = repoUi.createdAt
        )
        LabelToTextField(
            label = stringResource(R.string.watchers_label),
            text = repoUi.watchersCount.toString()
        )
        LabelToTextField(
            label = stringResource(R.string.stars_label),
            text = repoUi.stargazersCount.toString()
        )
        LabelToTextField(
            label = stringResource(R.string.issues_label),
            text = repoUi.openIssuesCount.toString()
        )
        LabelToTextField(
            label = stringResource(R.string.forks_label),
            text = repoUi.forksCount.toString()
        )
    }
}