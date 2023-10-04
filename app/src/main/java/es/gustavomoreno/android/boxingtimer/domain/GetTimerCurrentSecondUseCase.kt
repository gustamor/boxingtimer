package es.gustavomoreno.android.boxingtimer.domain

import android.util.Log
import androidx.compose.runtime.MutableLongState
import es.gustavomoreno.android.boxingtimer.data.repository.AssaultsTimerRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetTimerCurrentSecondUseCase @Inject constructor(private val repo: AssaultsTimerRepository) {
    operator fun invoke(): Long {
        Log.i("Sec from collect", repo.seconds.longValue.toString())
        return repo.seconds.longValue
    }
}