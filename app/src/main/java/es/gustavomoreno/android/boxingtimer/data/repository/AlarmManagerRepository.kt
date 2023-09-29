package es.gustavomoreno.android.boxingtimer.data.repository

import android.app.AlarmManager
import javax.inject.Inject

class AlarmManagerRepository @Inject constructor(private val alarmManager: AlarmManager) {
    fun get() = alarmManager
}

