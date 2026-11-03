package com.example.musicplayer.ui.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.musicplayer.model.Song
@Composable
fun PlayerScreen(
    song: Song,
    isPlaying: Boolean,
    onBack: () -> Unit,
    onPlayPause: () -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onVideoClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF15121E))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextButton(
            onClick = onBack,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("← Back", color = Color.White)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(song.cover),
            contentDescription = song.title,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)

                .clip(RoundedCornerShape(24.dp))
        )
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = song.title,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = song.artist,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(onClick = onPrevious) {
                Text("⏮", color = Color.White)
            }
            Button(
                onClick = onPlayPause,
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(
                    text = if (isPlaying) "II" else "▶"
                )
            }
            TextButton(onClick = onNext) {
                Text("⏭", color = Color.White)
            }

        }
        Spacer(modifier = Modifier.height(28.dp))
        Button(
            onClick = onVideoClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Watch Music Video")
        }
    }
}