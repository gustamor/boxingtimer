package es.gustavomoreno.android.boxingtimer.domain.useCase

import es.gustavomoreno.android.boxingtimer.data.repository.AssaultsTimerRepository
import es.gustavomoreno.android.boxingtimer.domain.ClockState
import es.gustavomoreno.android.boxingtimer.domain.model.CombatModel
import es.gustavomoreno.android.boxingtimer.domain.model.toData
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SetCombatTimerUseCase @Inject constructor(
    private val assaultsTimerRepository: AssaultsTimerRepository,
    private val getTimerCurrentSecondUseCase: GetTimerCurrentSecondUseCase
) {
    suspend operator fun invoke(
        rounds: Int = 12,
        roundTime: Int = 180,
        restTime: Int = 60,
        discountTime: Boolean = true
    ) {

        assaultsTimerRepository.setTimer(
            CombatModel(
                rounds = rounds,
                roundSeconds = roundTime,
                restSeconds = restTime,
                discountTime = discountTime
            ).toData()
        ).apply {
            assaultsTimerRepository.createCombatTimer()
        }
    }

}

