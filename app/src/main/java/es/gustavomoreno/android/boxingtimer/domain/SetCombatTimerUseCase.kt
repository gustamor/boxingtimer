package es.gustavomoreno.android.boxingtimer.domain

import es.gustavomoreno.android.boxingtimer.data.repository.AssaultsTimerRepository
import es.gustavomoreno.android.boxingtimer.domain.model.CombatModel
import es.gustavomoreno.android.boxingtimer.domain.model.toData
import javax.inject.Inject

class SetCombatTimerUseCase @Inject constructor(private val assaultsTimerRepository: AssaultsTimerRepository) {
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
            ).toData()).apply {
            assaultsTimerRepository.createCombatTimer()
        }
    }
}