package es.gustavomoreno.android.boxingtimer.data.repository

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import es.gustavomoreno.android.boxingtimer.domain.GetLongBellUseCase
import javax.inject.Inject


@AndroidEntryPoint
class AlarmTriggeredReceiver : BroadcastReceiver() {
    companion object {
        const val REQUEST_CODE_LONG: Int = 1
        const val LONG_ALARM_STARTED = "long_alarm_started"
    }

    @Inject
    lateinit var getLongBellUseCase: GetLongBellUseCase

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == LONG_ALARM_STARTED) {
            var mediaPlayer = getLongBellUseCase()
            mediaPlayer.start()
            Toast.makeText(context, "Long Alarm started!", Toast.LENGTH_SHORT).show()
        }
    }
}

