package es.gustavomoreno.android.boxingtimer.data.repository

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import es.gustavomoreno.android.boxingtimer.data.BoxingTimer
import es.gustavomoreno.android.boxingtimer.data.BoxingTimerBuilder
import es.gustavomoreno.android.boxingtimer.data.TimerFactory
import es.gustavomoreno.android.boxingtimer.data.repository.AlarmTriggeredReceiver.Companion.LONG_ALARM_STARTED
import es.gustavomoreno.android.boxingtimer.data.Combat
import es.gustavomoreno.android.boxingtimer.data.model.CombatModelData
import es.gustavomoreno.android.boxingtimer.domain.ClockCoroutineUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

import javax.inject.Inject

class AssaultsTimerRepository @Inject constructor(
    private val alarmManager: AlarmManager,
    private val clockCoroutineUseCase: ClockCoroutineUseCase
) :
    Combat {
    @Inject
    lateinit var context: Context
    override var numberOfRounds: Int = 12
        private set
    override var roundTime: Int = 3
        private set
    override var breakTime: Int = 1
        private set
    override var discountTime: Boolean = true
        private set
    override var combatTimers: MutableList<BoxingTimer> = mutableListOf()
        private set

    lateinit var seconds: MutableLongState
        private set

    override fun setTimer(combat: CombatModelData) {
        numberOfRounds = combat.rounds
        roundTime = combat.roundTime
        breakTime = combat.breakTime
        discountTime = combat.discountTime
    }

    val boxingTimer: BoxingTimerBuilder = BoxingTimerBuilder()
    private fun build(): MutableList<BoxingTimer> {

        val timers: MutableList<BoxingTimer> = mutableListOf()

        timers.add(boxingTimer.build(TimerFactory.DISCOUNT, 0, 10))
        for (round in 1..numberOfRounds) {
            timers.add(boxingTimer.build(TimerFactory.ROUND, round, roundTime))
            if (round < numberOfRounds) timers.add(
                boxingTimer.build(
                    TimerFactory.BREAK,
                    round,
                    breakTime
                )
            )
        }
        return timers
    }

    suspend fun createCombatTimer() {
        combatTimers = this.build()
        for (index in 0 until combatTimers.size) {
            val round = combatTimers[index]
            val intent = Intent(context, AlarmTriggeredReceiver::class.java)
            intent.action = LONG_ALARM_STARTED
            val pendingIntent =
                PendingIntent.getBroadcast(
                    context,
                    AlarmTriggeredReceiver.REQUEST_CODE_LONG,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
                )
            val duration = round.duration.toLong()
            val startedAt = SystemClock.elapsedRealtime()
            try {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    startedAt + duration * 1000,
                    pendingIntent
                )
                clockCoroutineUseCase(duration, startedAt).collect{
                    seconds = mutableLongStateOf(it)
                }
            } catch (e:SecurityException ) {
                throw SecurityException(e.message)
            } catch (e: Exception){
                throw Exception(e.message)
            }
        }
    }
}
