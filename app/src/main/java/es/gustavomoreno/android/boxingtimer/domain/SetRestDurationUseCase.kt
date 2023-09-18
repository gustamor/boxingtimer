package es.gustavomoreno.android.boxingtimer.domain

import es.gustavomoreno.android.boxingtimer.RestDuration
import javax.inject.Inject

class SetRestDurationUseCase @Inject constructor() {
    operator fun invoke(restDuration: RestDuration){}
}