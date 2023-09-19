package es.gustavomoreno.android.boxingtimer

abstract class BoxingTimer {
    abstract val id: Int
    abstract val duration: Int
    abstract val status: ClockStatus

}

enum class ClockStatus {
    IDLE, RUNNING, FINISHED
}
class RoundTimer(idTimer: Int, seconds: Int = 180) : BoxingTimer() {
    override val id: Int = idTimer
    override val duration: Int = seconds
    override val status: ClockStatus = ClockStatus.IDLE
}

class RestTimer(idTimer: Int, seconds: Int = 60) : BoxingTimer() {
    override val id: Int = idTimer
    override val duration: Int = seconds
    override val status: ClockStatus = ClockStatus.IDLE
}
class TenSeconds(idTimer: Int,seconds: Int = 10) : BoxingTimer() {
    override val id: Int = idTimer
    override val duration: Int = seconds
    override val status: ClockStatus = ClockStatus.IDLE
}
