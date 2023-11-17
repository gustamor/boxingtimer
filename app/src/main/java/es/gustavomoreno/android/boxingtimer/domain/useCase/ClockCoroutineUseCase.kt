package es.gustavomoreno.android.boxingtimer.domain.useCase


import javax.inject.Inject

class ClockCoroutineUseCase @Inject constructor(
    private val getLongBellUseCase: GetLongBellUseCase,
) {

    suspend operator fun invoke(duration: Long, startedAt: Long)  {
/*
        setCombatTimerUseCase.statusFLow.collect{
            Log.d("Sec", "ClockState UC ${it}")

            var current = duration
            while (current > -1) {
                when (it) {
                    FINISHED -> {

                    }
                    IDLE -> {
                        val elapsedTime: Long =
                            startedAt - SystemClock.elapsedRealtime() // the time that passed after the last time the user clicked the button
                        if (elapsedTime % 1000 == 0L) {
                            emit(current)
                            Log.d("Sec", current.toString())
                        }
                    }

                    RUNNING -> {
                        val elapsedTime: Long =
                            startedAt - SystemClock.elapsedRealtime() // the time that passed after the last time the user clicked the button
                        if (elapsedTime % 1000 == 0L) {
                            delay(1)
                            emit(current)
                            Log.d("Sec", current.toString())
                            current--
                        }
                    }

                }
            }

            var mediaPlayer = getLongBellUseCase()
            mediaPlayer.start()*/


        //Toast.makeText(context, "Long Alarm started!", Toast.LENGTH_SHORT).show()
    }
}