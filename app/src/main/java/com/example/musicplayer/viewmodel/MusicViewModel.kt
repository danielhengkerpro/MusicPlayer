package com.example.musicplayer.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.musicplayer.data.repository.MusicRepository
import com.example.musicplayer.model.Song
import com.example.musicplayer.player.MusicPlayerManager

class MusicViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MusicRepository()
    private val playerManager = MusicPlayerManager(application)
    val songs = repository.getSongs()

    var selectedSong = mutableStateOf<Song?>(null)
        private set
    var isPlaying = mutableStateOf(false)
        private set

    init {
        playerManager.onPlaybackChanged = { playing: Boolean ->
            isPlaying.value = playing
        }
    }

    fun selectSong(song: Song) {
        selectedSong.value = song
        playerManager.playAudio(song.audioRes)
    }

    fun togglePlayback() {
        playerManager.toggleAudio()
    }

    fun nextSong() {
        val currentSong = selectedSong.value ?: return
        val currentIndex = songs.indexOf(currentSong)
        val nextIndex = (currentIndex + 1) % songs.size
        selectSong(songs[nextIndex])
    }

    fun previousSong() {
        val currentSong = selectedSong.value ?: return
        val currentIndex = songs.indexOf(currentSong)
        val previousIndex = if (currentIndex == 0) songs.lastIndex else currentIndex - 1
        selectSong(songs[previousIndex])
    }

    fun playMusicVideo() {
        val song = selectedSong.value ?: return
        playerManager.pauseAudio()
        playerManager.playVideo(song.videoRes)
    }

    fun stopMusicVideo() {
        playerManager.stopVideo()
    }

    fun getVideoPlayer() = playerManager.videoPlayer

    override fun onCleared() {
        super.onCleared()
        playerManager.release()
    }
}
