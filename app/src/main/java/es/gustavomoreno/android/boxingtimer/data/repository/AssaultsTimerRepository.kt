package es.gustavomoreno.android.boxingtimer.data.repository

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import es.gustavomoreno.android.boxingtimer.BoxingTimer
import es.gustavomoreno.android.boxingtimer.RestTimer
import es.gustavomoreno.android.boxingtimer.RoundTimer
import es.gustavomoreno.android.boxingtimer.TenSeconds
import es.gustavomoreno.android.boxingtimer.data.model.CombatModelData
import javax.inject.Inject

@AndroidEntryPoint
class AssaultsTimerRepository : Combat {
    @Inject lateinit var alarmManager: AlarmManager
    @Inject @ApplicationContext lateinit var context: Context


    override lateinit var combat: CombatModelData
    override var numberOfRounds: Int = combat.rounds
        private set
    override var roundTime: Int = combat.roundTime
        private set
    override var restTime: Int = combat.restTime
        private set
    override var discountTime: Boolean =  combat.discountTime
        private set
    override var combatTimers: MutableList<BoxingTimer> = mutableListOf()
        private set

    fun createCombatTimer( ) {

        combatTimers.add(TenSeconds(0))

        for (n in 1..numberOfRounds) {
            combatTimers.add(RoundTimer(n, seconds = roundTime))
            if (n < numberOfRounds) combatTimers.add(RestTimer(n, seconds = restTime))
        }

        for (round in combatTimers) {
            val intent = Intent(context, YourAlarmReceiver::class.java)
            val pendingIntent =
                PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            val duration = round.duration.toLong()

            alarmManager.set(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + duration,
                pendingIntent
            )
        }
    }
}
class YourAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Do something when the alarm is triggered
        Toast.makeText(context, "Alarm triggered!", Toast.LENGTH_SHORT).show()
    }
}

interface Combat {
    val combat: CombatModelData
    val numberOfRounds: Int
    val roundTime : Int
    val restTime: Int
    val discountTime: Boolean
    val combatTimers: List<BoxingTimer>
}
