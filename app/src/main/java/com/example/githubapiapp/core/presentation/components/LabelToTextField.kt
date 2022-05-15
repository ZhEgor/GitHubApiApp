package com.example.githubapiapp.core.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubapiapp.R

@Composable
fun LabelToTextField(modifier: Modifier = Modifier, label: String, text: String) {
    Row(modifier = modifier) {
        Text(text = label, fontSize = 14.sp)
        Text(
            modifier = Modifier.padding(end = 4.dp),
            text = stringResource(R.string.colon),
            fontSize = 14.sp
        )
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }
}