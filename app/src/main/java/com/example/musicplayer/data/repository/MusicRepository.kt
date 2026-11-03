package com.example.musicplayer.data.repository
import com.example.musicplayer.R
import com.example.musicplayer.model.Song
class MusicRepository {
    fun getSongs(): List<Song> {
        return listOf(
            Song(
                id = 1,
                title = "Alexandra",
                artist = "Reality Club",
                cover = R.drawable.cv_alexandra,
                audioRes = R.raw.alexandra,
                videoRes = R.raw.mv_alexandra
            ),

            Song(
                id = 2,
                title = "Letdown",
                artist = "Hindia",
                cover = R.drawable.cv_letdown,
                audioRes = R.raw.letdown,
                videoRes = R.raw.mv_letdown
            ),
            Song(
                id = 3,
                title = "Semua Aku Dirayakan",
                artist = "Nadin Amizah",
                cover = R.drawable.cv_semua_aku_dirayakan,
                audioRes = R.raw.semua_aku_dirayakan,
                videoRes = R.raw.mv_semua_aku_dirayakan
            )
        )
    }
}