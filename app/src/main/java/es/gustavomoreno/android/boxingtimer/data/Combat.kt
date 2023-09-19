package es.gustavomoreno.android.boxingtimer.data

import es.gustavomoreno.android.boxingtimer.BoxingTimer
import es.gustavomoreno.android.boxingtimer.data.model.CombatModelData

interface Combat {
    fun setTimer(combat: CombatModelData)
    val numberOfRounds: Int
    val roundTime: Int
    val restTime: Int
    val discountTime: Boolean
    val combatTimers: List<BoxingTimer>
}