package com.example.musicplayer.ui.theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MusicPlayerColorScheme = darkColorScheme(
    primary = Color(0xFFB388FF),
    secondary = Color(0xFF9B72CF),
    background = Color(0xFF15121E),
    surface = Color(0xFF211D2B),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)
@Composable
fun MusicPlayerTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MusicPlayerColorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}