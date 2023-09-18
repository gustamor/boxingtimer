package es.gustavomoreno.android.boxingtimer.ui.theme.screen

import android.util.Log
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gustavomoreno.android.boxingtimer.RestDuration
import es.gustavomoreno.android.boxingtimer.RoundDuration
import es.gustavomoreno.android.boxingtimer.domain.SetDiscountTimeEnabled
import es.gustavomoreno.android.boxingtimer.domain.SetNumberOfRoundsUseCase
import es.gustavomoreno.android.boxingtimer.domain.SetRestDurationUseCase
import es.gustavomoreno.android.boxingtimer.domain.SetRoundDurationUseCase
import es.gustavomoreno.android.boxingtimer.domain.model.ejemplo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DurationsViewModel @Inject constructor(
    private val setNumberOfRoundsUseCase: SetNumberOfRoundsUseCase,
    private val setRestDurationUseCase: SetRestDurationUseCase,
    private val setRoundDurationUseCase: SetRoundDurationUseCase,
    private val setDiscountTimeEnabled: SetDiscountTimeEnabled
):ViewModel()  {

    var roundDuration: RoundDuration by  mutableStateOf(RoundDuration(1,180))
        private set

    var restIntervalDuration: RestDuration by mutableStateOf(RestDuration(1,60))
        private set

    var rounds: Int by mutableIntStateOf(1)
        private set
    var discountEnabled: Boolean by mutableStateOf(true)
        private set

    init {
        onDiscountTimeEnabled(true)
    }

    fun onRoundDurationChangeValue(value: Int) {
        viewModelScope.launch {
            roundDuration = RoundDuration(1,value)
            Log.i("GusMor roundDuration ",roundDuration.duration.toString() )
            setRoundDurationUseCase(roundDuration)
        }
    }
    fun onNumberOfRoundsChangeValue(value: Int) {
        viewModelScope.launch {
            rounds = value
            Log.i("GusMir roundDuration ",rounds.toString() )
            setNumberOfRoundsUseCase(rounds)
        }
    }

    fun onRestIntervalDurationChangeValue(value: Int) {
        viewModelScope.launch {
            restIntervalDuration =  RestDuration(1,value)
            setRestDurationUseCase(restIntervalDuration)
        }
    }
    fun onDiscountTimeEnabled(value: Boolean) {
        viewModelScope.launch {
            discountEnabled =  value
            setDiscountTimeEnabled(value)
        }
    }
}