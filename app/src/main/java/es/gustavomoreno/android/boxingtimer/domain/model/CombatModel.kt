package es.gustavomoreno.android.boxingtimer.domain.model

import es.gustavomoreno.android.boxingtimer.domain.ClockState
import es.gustavomoreno.android.boxingtimer.data.model.CombatModelData


data class CombatModel(
    val rounds: Int = 12,
    val roundSeconds: Int = 180,
    val restSeconds: Int = 60,
    val discountTime: Boolean = true,
    val state: ClockState = ClockState.IDLE
    )

fun CombatModel.toData() = CombatModelData(rounds,roundSeconds,restSeconds,discountTime, state)