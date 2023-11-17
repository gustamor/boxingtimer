package es.gustavomoreno.android.boxingtimer.domain.useCase

import android.app.AlarmManager
import android.app.PendingIntent
import javax.inject.Inject

class CancelAlarmManagerUseCase @Inject constructor(
    private val alarmManager: AlarmManager
) {
    operator fun invoke(   pendingIntent: PendingIntent) {
        alarmManager.cancel(pendingIntent)
    }
}