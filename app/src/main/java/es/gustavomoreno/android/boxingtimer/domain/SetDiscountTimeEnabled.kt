package es.gustavomoreno.android.boxingtimer.domain

import javax.inject.Inject

class SetDiscountTimeEnabled  @Inject constructor(){
    operator fun invoke(value: Boolean) {}
}