package es.gustavomoreno.android.boxingtimer.domain.useCase

import android.util.Log
import es.gustavomoreno.android.boxingtimer.domain.ClockState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChangeClockStateUseCase  @Inject constructor(){

    private var _statusFLow: Flow<ClockState> = flow{ emit(ClockState.RUNNING)}

    operator fun invoke(): Flow<ClockState> = _statusFLow

     suspend fun pauseClock() {
         Log.d("Sec", "ClockState PAUSE")
         _statusFLow = flow{ emit(ClockState.IDLE)}
         _statusFLow.collect{
             Log.d("Sec", "ClockState ${it}")
         }

     }
     suspend fun resumeClock() {
         Log.d("Sec", "ClockState RESUME")

         _statusFLow = flow{ emit(ClockState.RUNNING)}
         _statusFLow.collect{
             Log.d("Sec", "ClockState ${it}")
         }
     }
}