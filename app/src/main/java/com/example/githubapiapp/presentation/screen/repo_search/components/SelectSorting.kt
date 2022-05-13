package com.example.githubapiapp.presentation.screen.repo_search.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.example.githubapiapp.domain.model.dto.SortBy

@Composable
fun SelectSorting(modifier: Modifier = Modifier, selectedSorting: MutableState<SortBy>) {
    val sortingList = remember { SortBy.values().map { mutableStateOf(it) } }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.End
    ) {
        items(sortingList) { item ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (selectedSorting.value == item.value) MaterialTheme.colors.primaryVariant
                        else MaterialTheme.colors.primary
                    )
                    .clickable {
                        selectedSorting.value = item.value
                    }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                ) {
                    val isAsc = remember { mutableStateOf(item.value.asc) }
                    val angle: Float by animateFloatAsState(
                        targetValue = if (isAsc.value) 180f else 0f,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                        )
                    )
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .rotate(angle)
                            .clickable {
                                item.value.asc = !item.value.asc
                                isAsc.value = item.value.asc
                                selectedSorting.value = item.value
                            },
                        imageVector = Icons.Rounded.ExpandMore,
                        contentDescription = "sorting order",
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp),
                        text = item.value.sortName
                    )
                }
            }
        }
    }
}