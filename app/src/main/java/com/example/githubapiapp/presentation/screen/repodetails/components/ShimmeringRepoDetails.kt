package com.example.githubapiapp.presentation.screen.repodetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.githubapiapp.core.presentation.components.animatedShimmerBrush

@Composable
fun ShimmeringRepoDetails(modifier: Modifier) {
    val brush = animatedShimmerBrush()

    Column(modifier = modifier) {
        Spacer(
            modifier = Modifier
                .height(32.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )
    }
}