package es.gustavomoreno.android.boxingtimer.data.model

import es.gustavomoreno.android.boxingtimer.domain.ClockState


data class CombatModelData (
    val rounds: Int = 12,
    val roundTime: Int = 180,
    val breakTime: Int = 60,
    val discountTime: Boolean = true,
    val state: ClockState = ClockState.IDLE

)