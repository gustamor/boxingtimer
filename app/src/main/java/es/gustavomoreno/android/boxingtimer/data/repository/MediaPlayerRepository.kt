package es.gustavomoreno.android.boxingtimer.data.repository

import android.content.Context
import android.media.MediaPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import es.gustavomoreno.android.boxingtimer.R
import javax.inject.Inject

class MediaPlayerRepository @Inject constructor(@ApplicationContext private val context: Context) {
    fun longBell(): MediaPlayer {
        var mediaPlayer = MediaPlayer.create(context, R.raw.bell3)
        if (mediaPlayer?.isPlaying == true) mediaPlayer.pause()
        mediaPlayer?.seekTo(290) // El sonido comienza con este pequeño retardo
        return mediaPlayer
    }

    fun shortBell(): MediaPlayer {
        var mediaPlayer = MediaPlayer.create(context, R.raw.bell_one)
        if (mediaPlayer?.isPlaying == true) mediaPlayer.pause()
        return mediaPlayer
    }
}