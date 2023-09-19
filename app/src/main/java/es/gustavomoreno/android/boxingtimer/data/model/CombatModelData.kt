package es.gustavomoreno.android.boxingtimer.data.model


data class CombatModelData (
    val rounds: Int = 12,
    val roundTime: Int = 180,
    val restTime: Int = 60,
    val discountTime: Boolean = true,
)