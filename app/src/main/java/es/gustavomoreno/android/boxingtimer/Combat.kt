package es.gustavomoreno.android.boxingtimer

import es.gustavomoreno.android.boxingtimer.domain.model.CombatModel


interface Combat {
    val numberOfRounds: Int
    val discountTime: Boolean
    val clockDownTimer: List<BoxingTimer>
}

class AssaultsTimer constructor(combat: CombatModel) : Combat {
    override val numberOfRounds: Int = combat.rounds
    override val discountTime: Boolean = combat.discountTime
    override var clockDownTimer: MutableList<BoxingTimer> = mutableListOf()
        private set

    init {
        clockDownTimer.add(TenSeconds(0))
        for (n in 1..numberOfRounds) {
            clockDownTimer.add(RoundDuration(n))
            if (n < 12) clockDownTimer.add(RestDuration(n))
        }
    }
}