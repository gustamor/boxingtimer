package es.gustavomoreno.android.boxingtimer.domain

import es.gustavomoreno.android.boxingtimer.data.repository.AlarmManagerRepository
import javax.inject.Inject

class GetAlarmManagerUseCase @Inject constructor(private val alarmManager: AlarmManagerRepository){
    operator fun invoke() = alarmManager.get()
}
