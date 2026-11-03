package com.example.musicplayer.model
data class Song(
    val id: Int,
    val title: String,
    val artist: String,
    val cover: Int,
    val audioRes: Int,
    val videoRes: Int
)