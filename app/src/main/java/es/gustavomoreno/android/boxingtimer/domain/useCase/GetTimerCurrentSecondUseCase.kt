package es.gustavomoreno.android.boxingtimer.domain.useCase

import android.util.Log
import es.gustavomoreno.android.boxingtimer.data.repository.AssaultsTimerRepository
import javax.inject.Inject

class GetTimerCurrentSecondUseCase @Inject constructor(private val repo: AssaultsTimerRepository) {
    operator fun invoke(): Long {
       /* Log.i("Sec from collect", repo.seconds.longValue.toString())
        return repo.seconds.longValue*/
        return 0L
    }
}