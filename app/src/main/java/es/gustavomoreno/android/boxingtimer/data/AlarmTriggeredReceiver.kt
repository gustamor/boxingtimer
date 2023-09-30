package es.gustavomoreno.android.boxingtimer.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import es.gustavomoreno.android.boxingtimer.R


@AndroidEntryPoint
class AlarmTriggeredReceiver : BroadcastReceiver() {
    companion object{
        const val REQUEST_CODE: Int = 1
    }

    private var mediaPlayer: MediaPlayer? = null
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "ALARM_STARTED") {
            mediaPlayer = MediaPlayer.create(context, R.raw.bell_3 )

            mediaPlayer?.seekTo(0)
            mediaPlayer?.start()
            Log.d("Sec", "Alarm started")
            Toast.makeText(context, "Alarm started!", Toast.LENGTH_SHORT).show()
        }
    }
}

