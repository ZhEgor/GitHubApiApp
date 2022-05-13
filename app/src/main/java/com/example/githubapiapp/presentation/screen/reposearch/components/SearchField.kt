package com.example.githubapiapp.presentation.screen.reposearch.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.example.githubapiapp.R
import com.example.githubapiapp.core.presentation.composableState.TextFieldState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    searchState: MutableState<TextFieldState>,
    onSearch: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        modifier = modifier,
        value = searchState.value.text,
        enabled = searchState.value.enabled,
        label = { Text(text = stringResource(R.string.search_label)) },
        onValueChange = {
            searchState.value = searchState.value.copy(text = it)
        },
        trailingIcon = {
            if (searchState.value.text.isNotEmpty()) {
                IconButton(onClick = {
                    searchState.value = searchState.value.copy(text = "")
                }) {
                    Icon(
                        imageVector = Icons.Filled.Cancel,
                        contentDescription = stringResource(R.string.remove_text_description)
                    )
                }
            }
        },
        leadingIcon = {
            IconButton(
                onClick = {
                    onSearch()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_by_text_description)
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = MaterialTheme.colors.primaryVariant,
            focusedBorderColor = MaterialTheme.colors.primaryVariant,
            cursorColor = MaterialTheme.colors.primaryVariant
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
                keyboardController?.hide()
            }
        )
    )
}