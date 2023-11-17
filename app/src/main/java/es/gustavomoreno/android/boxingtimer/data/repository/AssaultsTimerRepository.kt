package es.gustavomoreno.android.boxingtimer.data.repository

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import es.gustavomoreno.android.boxingtimer.data.BoxingTimer
import es.gustavomoreno.android.boxingtimer.data.BoxingTimerBuilder
import es.gustavomoreno.android.boxingtimer.data.TimerFactory
import es.gustavomoreno.android.boxingtimer.data.Combat
import es.gustavomoreno.android.boxingtimer.data.model.CombatModelData
import es.gustavomoreno.android.boxingtimer.domain.ClockState
import es.gustavomoreno.android.boxingtimer.domain.ClockState.FINISHED
import es.gustavomoreno.android.boxingtimer.domain.useCase.ChangeClockStateUseCase
import es.gustavomoreno.android.boxingtimer.domain.useCase.GetLongBellUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


import javax.inject.Inject

class AssaultsTimerRepository @Inject constructor(
    private val getLongBellUseCase: GetLongBellUseCase,
    private val changeClockStateUseCase: ChangeClockStateUseCase,
) : Combat {

    private var prevState: ClockState = ClockState.FINISHED
    private var leftTime: Long = 0L
    private var startedAt: Long = 0L
    private var duration: Long = 0L
    private lateinit var pendingIntent: PendingIntent
    private lateinit var intent: Intent
    private lateinit var currentTimerType: String
    private lateinit var round: BoxingTimer


    private var _clockStateFlow: Flow<ClockState> = changeClockStateUseCase()

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

    override fun setTimer(combat: CombatModelData) {
        numberOfRounds = combat.rounds
        roundTime = combat.roundTime
        breakTime = combat.breakTime
        discountTime = combat.discountTime
    }

    val boxingTimer: BoxingTimerBuilder = BoxingTimerBuilder()
    private fun buildTimers(): MutableList<BoxingTimer> {
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
        combatTimers = this.buildTimers()
        startTimers()
    }

    //TODO: Poner el Timer activo en un Channel (bidireccional)
   @SuppressLint("SuspiciousIndentation")
   private suspend fun startTimers() {
        for (round in combatTimers) {
           // changeClockStateUseCase.resumeClock()

            duration = round.duration.toLong()
            startedAt = SystemClock.elapsedRealtime()

            try {
                var current = duration
                    CoroutineScope(Dispatchers.IO).launch {  }
                      _clockStateFlow.collect{
                        while (current > -1) {
                        when (it) {
                            FINISHED -> {}
                            ClockState.IDLE -> {
                                Log.d("Sec", "ClockState IDLE: ${it}")
                                val elapsedTime: Long =
                                    startedAt - SystemClock.elapsedRealtime()
                                if (elapsedTime % 1000 == 0L) {
                                    Log.d("Sec", current.toString())
                                }
                            }

                            ClockState.RUNNING -> {
                                val elapsedTime: Long =
                                    startedAt - SystemClock.elapsedRealtime()
                                if (elapsedTime % 1000 == 0L) {
                                    Log.d("Sec", "ClockState RUN: ${it}")
                                    delay(1)
                                    Log.d("Sec", current.toString())
                                    current--
                                }
                            }
                        }
                    }

                          //TODO: La campana es parte orgánica del reloj
                    val mediaPlayer = getLongBellUseCase()
                    mediaPlayer.start()
               //     changeClockStateUseCase.pauseClock()
                }

            } catch (e: SecurityException) {
                throw SecurityException(e.message)
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }
}
