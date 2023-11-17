package es.gustavomoreno.android.boxingtimer.domain

sealed interface ClockState {
    object IDLE: ClockState
    object RUNNING: ClockState
    object FINISHED: ClockState

}
