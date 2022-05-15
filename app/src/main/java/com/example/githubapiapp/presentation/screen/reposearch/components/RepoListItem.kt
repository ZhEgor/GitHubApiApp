package com.example.githubapiapp.presentation.screen.reposearch.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BugReport
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.Mediation
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.githubapiapp.R
import com.example.githubapiapp.domain.model.ui.RepoUi
import com.example.githubapiapp.presentation.util.ext.setSizeInImageUrl

@Composable
fun RepoListItem(modifier: Modifier = Modifier, repoUi: RepoUi, onClick: (RepoUi) -> Unit) {
    val uriHandler = LocalUriHandler.current

    Box(modifier = modifier.clickable { onClick(repoUi) }) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = repoUi.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                        text = repoUi.owner.login,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .clickable {
                            uriHandler.openUri(repoUi.owner.htmlUrl)
                        },
                    painter = rememberAsyncImagePainter(
                        model = repoUi.owner.avatarUrl.setSizeInImageUrl(size = 30)
                    ),
                    contentDescription = stringResource(R.string.thumbnail_avatar_description),
                )
            }

            Row(modifier.padding(horizontal = 4.dp)) {
                IconWithText(
                    modifier = Modifier.weight(1f),
                    text = repoUi.watchersCount.toString(),
                    imageVector = Icons.Rounded.Visibility,
                    contentDescription = stringResource(R.string.number_of_watchers_description)
                )
                IconWithText(
                    modifier = Modifier.weight(1f),
                    text = repoUi.forksCount.toString(),
                    imageVector = Icons.Rounded.Mediation,
                    contentDescription = stringResource(R.string.number_of_forks_description)
                )
                IconWithText(
                    modifier = Modifier.weight(1f),
                    text = repoUi.openIssuesCount.toString(),
                    imageVector = Icons.Rounded.BugReport,
                    contentDescription = stringResource(R.string.number_of_issues_description)
                )
                if (repoUi.language.isNotBlank()) {
                    IconWithText(
                        modifier = Modifier.weight(1f),
                        text = repoUi.language,
                        imageVector = Icons.Rounded.Language,
                        contentDescription = stringResource(R.string.language_description)
                    )
                }
            }
        }
    }
}

@Composable
private fun IconWithText(
    modifier: Modifier = Modifier,
    text: String,
    imageVector: ImageVector,
    contentDescription: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(16.dp)
                .clip(CircleShape),
            imageVector = imageVector,
            contentDescription = contentDescription
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            text = text,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}