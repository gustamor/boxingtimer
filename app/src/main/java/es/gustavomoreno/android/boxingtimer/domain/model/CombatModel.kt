package es.gustavomoreno.android.boxingtimer.domain.model

import android.util.Log
import es.gustavomoreno.android.boxingtimer.AssaultsTimer
import es.gustavomoreno.android.boxingtimer.RestDuration
import es.gustavomoreno.android.boxingtimer.RoundDuration
import kotlin.reflect.typeOf

data class CombatModel(
    val rounds: Int = 12,
    val durationRound: Int = 180,
    val restDuration: Int = 60,
    val discountTime: Boolean = true,

    )

fun ejemplo() {

    val aa = AssaultsTimer(
        CombatModel(
            rounds = 12,
            durationRound = 180,
            restDuration = 60,
            discountTime = true
        )
    )
    aa.clockDownTimer.map{
        Log.i("GusMor ejemplo: ", "type: ${it.javaClass.kotlin.simpleName} id: ${it.id}")
    }



}