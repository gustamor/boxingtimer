package es.gustavomoreno.android.boxingtimer.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlarmTriggeredReceiver : BroadcastReceiver() {
    companion object{
        const val REQUEST_CODE: Int = 1
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "ALARM_STARTED") {
            Log.d("Sec", "Alarm started")
            Toast.makeText(context, "Alarm started!", Toast.LENGTH_SHORT).show()
        }
    }
}

