package es.gustavomoreno.android.boxingtimer.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlarmTriggeredReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "ALARM_STARTED") {
            Toast.makeText(context, "Alarm started!", Toast.LENGTH_SHORT).show()
        }
    }
}