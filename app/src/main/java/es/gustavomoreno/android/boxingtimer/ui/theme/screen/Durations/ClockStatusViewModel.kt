package es.gustavomoreno.android.boxingtimer.ui.theme.screen.Durations

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gustavomoreno.android.boxingtimer.domain.useCase.ChangeClockStateUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClockStatusViewModel @Inject constructor(private val changeClockStateUseCase: ChangeClockStateUseCase):
    ViewModel() {

    fun pauseClock() {
        viewModelScope.launch {
            changeClockStateUseCase.pauseClock()
      }
    }

    fun resumeClock() {
        viewModelScope.launch {
            changeClockStateUseCase.resumeClock()
        }
    }
}