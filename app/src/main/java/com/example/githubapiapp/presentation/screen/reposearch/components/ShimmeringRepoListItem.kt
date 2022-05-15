package com.example.githubapiapp.presentation.screen.reposearch.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.githubapiapp.core.presentation.components.animatedShimmerBrush

@Composable
fun ShimmeringRepoListItem(modifier: Modifier = Modifier) {
    val brush = animatedShimmerBrush(
        shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.8f),
            Color.LightGray.copy(alpha = 0.3f),
            Color.LightGray.copy(alpha = 0.8f),
        )
    )

    Box(modifier = modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(modifier = Modifier.padding(bottom = 4.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                            .width(200.dp)
                            .padding(start = 4.dp, bottom = 6.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(brush)
                    )
                    Spacer(
                        modifier = Modifier
                            .height(24.dp)
                            .width(260.dp)
                            .padding(start = 4.dp, bottom = 4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(brush)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(brush)
                )
            }
            Spacer(
                modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth()
                    .padding(start = 4.dp, bottom = 4.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(brush)
            )
        }
    }
}