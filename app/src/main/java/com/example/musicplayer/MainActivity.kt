package com.example.musicplayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.musicplayer.ui.screen.HomeScreen
import com.example.musicplayer.ui.screen.PlayerScreen
import com.example.musicplayer.ui.screen.VideoScreen
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import com.example.musicplayer.viewmodel.MusicViewModel
class MainActivity : ComponentActivity() {
    private val viewModel: MusicViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                var currentScreen by remember {
                    mutableStateOf("home")
                }
                BackHandler(
                    enabled = currentScreen != "home"
                ) {
                    when (currentScreen) {
                        "video" -> {

                            viewModel.stopMusicVideo()
                            currentScreen = "player"
                        }
                        "player" -> {
                            currentScreen = "home"
                        }
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF15121E)
                ) {
                    when (currentScreen) {
                        "home" -> {
                            HomeScreen(
                                songs = viewModel.songs,
                                selectedSong = viewModel.selectedSong.value,
                                isPlaying = viewModel.isPlaying.value,
                                onSongClick = { song ->
                                    viewModel.selectSong(song)
                                    currentScreen = "player"
                                },
                                onMiniPlayerClick = {
                                    currentScreen = "player"
                                },
                                onPlayPause = {
                                    viewModel.togglePlayback()
                                }
                            )
                        }
                        "player" -> {

                            val song = viewModel.selectedSong.value
                            if (song != null) {
                                PlayerScreen(
                                    song = song,
                                    isPlaying = viewModel.isPlaying.value,
                                    onBack = {
                                        currentScreen = "home"
                                    },
                                    onPlayPause = {
                                        viewModel.togglePlayback()
                                    },
                                    onNext = {
                                        viewModel.nextSong()
                                    },
                                    onPrevious = {
                                        viewModel.previousSong()
                                    },
                                    onVideoClick = {
                                        viewModel.playMusicVideo()
                                        currentScreen = "video"
                                    }
                                )
                            }
                        }
                        "video" -> {
                            val song = viewModel.selectedSong.value
                            if (song != null) {
                                VideoScreen(

                                    song = song,
                                    player = viewModel.getVideoPlayer(),
                                    onBack = {
                                        viewModel.stopMusicVideo()
                                        currentScreen = "player"
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}