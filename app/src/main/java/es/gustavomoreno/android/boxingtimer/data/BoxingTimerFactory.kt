package es.gustavomoreno.android.boxingtimer.data

interface BoxingTimerFactory {
    fun createTimer(roundNumber: Int, roundTime: Int): BoxingTimer
}

class TenSecondsFactory: BoxingTimerFactory {
    override fun createTimer(roundNumber: Int, roundTime: Int): BoxingTimer {
        return TenSeconds(roundNumber, roundTime)
    }
}

class RoundTimerFactory: BoxingTimerFactory {
    override fun createTimer(roundNumber: Int, roundTime: Int): BoxingTimer {
        return RoundTimer(roundNumber, seconds = roundTime)
    }
}

class RestTimerFactory: BoxingTimerFactory {
    override fun createTimer(roundNumber: Int, roundTime: Int): BoxingTimer {
        return RestTimer(roundNumber,roundTime)
    }
}

object TimerFactory{
    const val DISCOUNT = "DiscountTimer"
    const val ROUND = "RoundTimer"
    const val BREAK = "BreakTimer"

}

class BoxingTimerBuilder {
    private fun createFactory(factory: String): BoxingTimerFactory {
        return when (factory) {
            TimerFactory.DISCOUNT -> TenSecondsFactory()
            TimerFactory.ROUND -> RoundTimerFactory()
            TimerFactory.BREAK -> RestTimerFactory()
            else -> throw IllegalArgumentException("Invalid factory name")
        }
    }
    fun build(factory: String, roundNumber: Int, seconds: Int): BoxingTimer {
        val boxingTimerFactory = createFactory(factory)
        return boxingTimerFactory.createTimer(roundNumber, seconds)
    }
}