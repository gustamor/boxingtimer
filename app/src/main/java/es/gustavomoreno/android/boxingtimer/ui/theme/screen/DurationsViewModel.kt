package es.gustavomoreno.android.boxingtimer.ui.theme.screen

import android.util.Log
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DurationsViewModel @Inject constructor():ViewModel()  {

    var roundDuration: Int by mutableIntStateOf(12)
        private set

    var restIntervalDuration: Int by mutableIntStateOf(1)
        private set

    var rounds: Int by mutableIntStateOf(1)
        private set

    init {
        roundDuration = 3 * 60
        restIntervalDuration = 1 * 60
        rounds = 12
    }

    fun onRoundDurationChangeValue(value: Int) {
        viewModelScope.launch {
            roundDuration = value
            Log.i("GusMir roundDuration ",roundDuration.toString() )
        }
    }
    fun onRoundsChangeValue(value: Int) {
        viewModelScope.launch {
            restIntervalDuration = value
        }
    }
    fun onRestIntervalDurationChangeValue(value: Int) {
        viewModelScope.launch {
            restIntervalDuration = value
        }
    }

}