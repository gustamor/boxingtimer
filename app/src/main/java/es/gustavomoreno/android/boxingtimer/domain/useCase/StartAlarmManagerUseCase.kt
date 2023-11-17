package es.gustavomoreno.android.boxingtimer.domain.useCase

import android.app.AlarmManager
import android.app.PendingIntent
import javax.inject.Inject

class StartAlarmManagerUseCase @Inject constructor(
   private val alarmManager: AlarmManager
) {
     operator fun invoke(
        startedAt: Long,
        duration: Long,
        pendingIntent: PendingIntent
    ) {
         alarmManager.setExactAndAllowWhileIdle(
             AlarmManager.ELAPSED_REALTIME_WAKEUP,
             startedAt + duration * 1000,
             pendingIntent
         )

    }
}

