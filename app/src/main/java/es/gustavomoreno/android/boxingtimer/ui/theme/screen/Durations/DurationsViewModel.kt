package es.gustavomoreno.android.boxingtimer.ui.theme.screen.Durations

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gustavomoreno.android.boxingtimer.domain.GetTimerCurrentSecondUseCase
import es.gustavomoreno.android.boxingtimer.domain.SetCombatTimerUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DurationsViewModel @Inject constructor(
    private val setCombatTimerUseCase: SetCombatTimerUseCase,
    private val getTimerCurrentSecondUseCase: GetTimerCurrentSecondUseCase
) : ViewModel() {

    var roundSeconds: Int by mutableIntStateOf(7)
        private set
    var restSeconds: Int by mutableIntStateOf(5)
        private set
    var numberOfRounds: Int by mutableIntStateOf(1102)
        private set
    var discountEnabled: Boolean by mutableStateOf(true)
        private set

    var isRunning: Boolean by mutableStateOf(false)
        private set

    fun onStarted() {
        viewModelScope.launch {
            setCombatTimerUseCase(
                rounds = numberOfRounds,
                roundTime = roundSeconds,
                restTime = restSeconds,
                discountTime = discountEnabled
            )

        }
    }

    fun onRoundDurationChangeValue(value: Int?) {
        viewModelScope.launch {
            roundSeconds = value ?: 180
        }
    }

    fun onNumberOfRoundsChangeValue(value: Int?) {
        viewModelScope.launch {
            numberOfRounds = value ?: 12
        }
    }

    fun onRestIntervalDurationChangeValue(value: Int?) {
        viewModelScope.launch {
            restSeconds = value ?: 60
        }
    }

    fun onDiscountTimeEnabled(value: Boolean?) {
        viewModelScope.launch {
            discountEnabled = value ?: true
        }
    }
    fun toggleStartStop() {
        viewModelScope.launch { }
    }
}