package com.example.githubapiapp.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.githubapiapp.R

@Composable
fun ErrorDialog(
    modifier: Modifier = Modifier,
    isDialogActive: MutableState<Boolean>,
    onClick: () -> Unit
) {
    Dialog(onDismissRequest = { isDialogActive.value = false }) {
        androidx.compose.material.Surface(
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colors.surface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StateCard(
                    text = stringResource(R.string.error_state_text),
                    painter = painterResource(id = R.drawable.ic_error),
                    contentDescription = stringResource(R.string.error_state_description)
                )
                Button(
                    onClick = {
                        onClick()
                        isDialogActive.value = false
                    }
                ) {
                    Text(text = stringResource(R.string.try_again_button))
                }
            }
        }
    }
}