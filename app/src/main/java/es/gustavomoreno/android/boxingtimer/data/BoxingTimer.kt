package es.gustavomoreno.android.boxingtimer.data

interface BoxingTimer {
     val id: Int
     val duration: Int
     val remainingTime: Long
}


class RoundTimer(idTimer: Int, seconds: Int = 180) : BoxingTimer {
    override val id: Int = idTimer
    override val duration: Int = seconds
    override val remainingTime: Long = seconds.toLong()

}

class RestTimer(idTimer: Int, seconds: Int = 60) : BoxingTimer {
    override val id: Int = idTimer
    override val duration: Int = seconds
    override val remainingTime: Long = seconds.toLong()
}

class TenSeconds(idTimer: Int,seconds: Int = 10) : BoxingTimer {
    override val id: Int = idTimer
    override val duration: Int = seconds
    override val remainingTime: Long = seconds.toLong()
}
