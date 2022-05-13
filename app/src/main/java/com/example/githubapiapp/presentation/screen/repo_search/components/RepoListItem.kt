package com.example.githubapiapp.presentation.screen.repo_search.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.githubapiapp.domain.model.ui.RepoUi

@Composable
fun RepoListItem(modifier: Modifier = Modifier, repoUi: RepoUi) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "name: " + repoUi.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                        text = "owner: " + repoUi.shortUserUi.id.toString(),
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape),
                    painter = rememberAsyncImagePainter(repoUi.shortUserUi.avatarUrl),
                    contentDescription = "thumbnail avatar"
                )
            }

            Row {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape),
                        imageVector = Icons.Rounded.Visibility,
                        contentDescription = "number of watchers"
                    )
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        text = repoUi.watchersCount.toString(),
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape),
                        imageVector = Icons.Rounded.Mediation,
                        contentDescription = "number of forks"
                    )
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        text = repoUi.forksCount.toString(),
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape),
                        imageVector = Icons.Rounded.BugReport,
                        contentDescription = "number of issues"
                    )
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        text = repoUi.watchersCount.toString(),
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (repoUi.language.isNotBlank()) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp)
                                .clip(CircleShape),
                            imageVector = Icons.Rounded.Language,
                            contentDescription = "language"
                        )
                        Text(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp),
                            text = repoUi.language,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}