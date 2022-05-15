package com.example.githubapiapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    error = ErrorRed,
    onError = GhostWhite
)

private val LightColorPalette = lightColors(
    primary = PeriwinkleCrayola,
    primaryVariant = MaximumBluePurple,
    onPrimary = DarkGray,
    secondary = UranianBlue,
    secondaryVariant = BabyBlueEyes,
    onSecondary = DarkGray,
    background = White,
    onBackground = Black60,
    surface = GhostWhite,
    onSurface = Black60,
    error = ErrorRed,
    onError = GhostWhite
)

@Composable
fun GitHubApiAppTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}