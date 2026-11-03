package com.example.musicplayer.player

import android.content.Context
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer

class MusicPlayerManager(context: Context) {
    private val appContext = context.applicationContext
    val audioPlayer = ExoPlayer.Builder(appContext).build()
    val videoPlayer = ExoPlayer.Builder(appContext).build()
    var onPlaybackChanged: (Boolean) -> Unit = {}

    init {
        audioPlayer.addListener(
            object : Player.Listener {
                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    onPlaybackChanged(isPlaying)
                }
            }
        )
    }

    private fun getResourceUri(resourceId: Int): Uri {
        return Uri.parse(
            "android.resource://${appContext.packageName}/$resourceId"
        )
    }

    fun playAudio(resourceId: Int) {
        val mediaItem = MediaItem.fromUri(
            getResourceUri(resourceId)
        )
        audioPlayer.setMediaItem(mediaItem)
        audioPlayer.prepare()
        audioPlayer.play()
    }

    fun toggleAudio() {
        if (audioPlayer.isPlaying) {
            audioPlayer.pause()
        } else {
            audioPlayer.play()
        }
    }

    fun pauseAudio() {
        audioPlayer.pause()
    }

    fun playVideo(resourceId: Int) {
        val mediaItem = MediaItem.fromUri(
            getResourceUri(resourceId)
        )
        videoPlayer.setMediaItem(mediaItem)
        videoPlayer.prepare()
        videoPlayer.play()
    }

    fun stopVideo() {
        videoPlayer.stop()
    }

    fun release() {
        audioPlayer.release()
        videoPlayer.release()
    }
}
