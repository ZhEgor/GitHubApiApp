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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StateCard(
    modifier: Modifier = Modifier,
    text: String,
    painter: Painter,
    contentDescription: String
) {
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
            painter = painter,
            contentDescription = contentDescription,
            tint = Color.Unspecified
        )
        Text(
            modifier = Modifier.width(200.dp),
            text = text,
            textAlign = TextAlign.Center,
        )
    }
}