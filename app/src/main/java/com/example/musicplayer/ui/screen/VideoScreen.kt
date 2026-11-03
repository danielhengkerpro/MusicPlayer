package com.example.musicplayer.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.annotation.OptIn
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.musicplayer.model.Song

@OptIn(UnstableApi::class)
@Composable
fun VideoScreen(
    song: Song,
    player: ExoPlayer,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF15121E))
            .padding(16.dp)
    ) {
        TextButton(onClick = onBack) {
            Text(
                text = "← Back",
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    this.player = player
                    useController = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = song.title,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = song.artist,
            color = Color.LightGray
        )
    }
}
