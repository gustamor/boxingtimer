package es.gustavomoreno.android.boxingtimer.domain

import android.os.SystemClock
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClockCoroutineUseCase @Inject constructor() {
    suspend operator fun invoke(duration: Long, startedAt: Long) =  flow {
            var current = duration
            while (current > -1) {
                val elapsedTime: Long =
                    startedAt - SystemClock.elapsedRealtime() // the time that passed after the last time the user clicked the button
                if (elapsedTime % 1000 == 0.toLong()) {
                    delay(1)
                    emit(current)
                    Log.d("Sec", current.toString())
                    current--
                }
            }
        }
}