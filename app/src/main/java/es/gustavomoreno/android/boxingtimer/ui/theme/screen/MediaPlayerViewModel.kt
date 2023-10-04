package es.gustavomoreno.android.boxingtimer.ui.theme.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gustavomoreno.android.boxingtimer.domain.GetShortBellUseCase
import javax.inject.Inject

@HiltViewModel
class MediaPlayerViewModel @Inject constructor(
    private val getShortBellUseCase: GetShortBellUseCase
): ViewModel() {

    fun playShortBell() {
        getShortBellUseCase().start()
    }


}
