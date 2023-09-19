package es.gustavomoreno.android.boxingtimer.data.repository

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import es.gustavomoreno.android.boxingtimer.BoxingTimer
import es.gustavomoreno.android.boxingtimer.RestTimer
import es.gustavomoreno.android.boxingtimer.RoundTimer
import es.gustavomoreno.android.boxingtimer.TenSeconds
import es.gustavomoreno.android.boxingtimer.data.AlarmTriggeredReceiver
import es.gustavomoreno.android.boxingtimer.data.Combat
import es.gustavomoreno.android.boxingtimer.data.model.CombatModelData
import es.gustavomoreno.android.boxingtimer.domain.GetAlarmManagerUseCase
import kotlinx.coroutines.delay
import javax.inject.Inject


class AssaultsTimerRepository @Inject constructor(var getAlarmManagerUseCase: GetAlarmManagerUseCase) :
    Combat {


    @Inject
    lateinit var context: Context

    override var numberOfRounds: Int = 12
        private set
    override var roundTime: Int = 3
        private set
    override var restTime: Int = 1
        private set
    override var discountTime: Boolean = true
        private set
    override var combatTimers: MutableList<BoxingTimer> = mutableListOf()
        private set
    override fun setTimer(combat: CombatModelData) {
        numberOfRounds = combat.rounds
        roundTime = combat.roundTime
        restTime = combat.restTime
        discountTime = combat.discountTime
    }

    suspend fun createCombatTimer() {
        combatTimers.add(TenSeconds(0))

        for (n in 1..numberOfRounds) {
            combatTimers.add(RoundTimer(n, seconds = roundTime))
            if (n < numberOfRounds) combatTimers.add(RestTimer(n, seconds = restTime))
        }

        for (index in 0 until combatTimers.size) {
            val round = combatTimers[index]

            val intent = Intent(context, AlarmTriggeredReceiver::class.java)
            intent.action = "ALARM_STARTED"

            val pendingIntent =
                PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val duration = round.duration.toLong()

            Log.i("GusMor Duration", intent.toString())

            try {
                getAlarmManagerUseCase().set(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + duration,
                    pendingIntent
                )
                delay(round.duration.toLong() * 1000)
            } catch (e: Exception) {
                Log.i("GusMor", e.toString())
            }
        }
    }
}

