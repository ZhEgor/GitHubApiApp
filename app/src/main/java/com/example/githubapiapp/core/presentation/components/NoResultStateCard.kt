package com.example.githubapiapp.core.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.githubapiapp.R

@Composable
fun NoResultStateCard(modifier: Modifier = Modifier, text: String = "") {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.size(
                width = 150.dp,
                height = 100.dp
            ),
            painter = painterResource(id = R.drawable.ic_no_search_result),
            contentDescription = "no search result",
            tint = Color.Unspecified
        )
        Text(
            modifier = Modifier.width(200.dp),
            text = text,
            textAlign = TextAlign.Center,
        )
    }
}