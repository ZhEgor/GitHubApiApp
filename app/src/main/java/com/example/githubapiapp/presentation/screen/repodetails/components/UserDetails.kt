package com.example.githubapiapp.presentation.screen.repodetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.People
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.githubapiapp.R
import com.example.githubapiapp.core.presentation.components.LabelToTextField
import com.example.githubapiapp.domain.model.ui.FullUserUi

@Composable
fun UserDetails(
    modifier: Modifier = Modifier,
    userUi: FullUserUi,
    onFollowLink: (String) -> Unit
) {
    Row(modifier = modifier) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        onFollowLink(userUi.htmlUrl)
                    },
                painter = rememberAsyncImagePainter(model = userUi.avatarUrl),
                contentDescription = stringResource(R.string.avatar_description),
            )
            FollowersAndFollowingBlock(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 8.dp),
                followersCount = userUi.followersCount,
                followingCount = userUi.followingCount
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = userUi.login,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            if (userUi.email.isNotEmpty()) {
                LabelToTextField(label = stringResource(R.string.email_label), text = userUi.email)
            }
            LabelToTextField(
                label = stringResource(R.string.repositories_label),
                text = userUi.publicReposCount.toString()
            )
        }
    }
}

@Composable
private fun FollowersAndFollowingBlock(
    modifier: Modifier = Modifier,
    followersCount: Int,
    followingCount: Int,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(16.dp)
                .clip(CircleShape),
            imageVector = Icons.Outlined.People,
            contentDescription = stringResource(R.string.followers_and_following_description)
        )
        Text(
            modifier = Modifier.padding(end = 4.dp),
            text = followersCount.toString(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.padding(end = 4.dp),
            text = stringResource(R.string.followers_count),
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Divider(
            modifier = Modifier
                .size(1.dp)
                .padding(horizontal = 4.dp)
        )
        Text(
            modifier = Modifier.padding(end = 4.dp),
            text = followingCount.toString(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = stringResource(R.string.following_count),
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}