package es.gustavomoreno.android.boxingtimer.data.repository

import android.annotation.SuppressLint
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
import kotlinx.coroutines.coroutineScope
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

    private fun build(): MutableList<BoxingTimer> {
        val _combatTimers: MutableList<BoxingTimer> = mutableListOf()

        _combatTimers.add(TenSeconds(0))
        for (n in 1..numberOfRounds) {
            _combatTimers.add(RoundTimer(n, seconds = roundTime))
            if (n < numberOfRounds) _combatTimers.add(RestTimer(n, seconds = restTime))
        }
        return _combatTimers
    }

    @SuppressLint("ScheduleExactAlarm")
    suspend fun createCombatTimer() {

        combatTimers = build()

        for (index in 0 until combatTimers.size) {
                  val round = combatTimers[index]
            val intent = Intent(context, AlarmTriggeredReceiver::class.java)
            intent.action = "ALARM_STARTED"
            val pendingIntent =
                PendingIntent.getBroadcast(
                    context,
                    AlarmTriggeredReceiver.REQUEST_CODE,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
                )
            val duration = round.duration.toLong()
            val startedAt = SystemClock.elapsedRealtime()
            try {
                getAlarmManagerUseCase().setExact(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    startedAt + duration * 1000,
                    pendingIntent
                )

                coroutineScope {
                    var current = duration
                    while (current > -1) {
                        val elapsedTime: Long =
                            startedAt - SystemClock.elapsedRealtime() // the time that passed after the last time the user clicked the button
                        if (elapsedTime % 1000 == 0.toLong()) {
                            delay(1)
                            Log.d("Sec",current.toString())
                            current--

                        }
                    }
                }
            } catch (e: Exception) {
                Log.i("GusMor", e.toString())
            }
        }
    }
}
