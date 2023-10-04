package es.gustavomoreno.android.boxingtimer.domain

import es.gustavomoreno.android.boxingtimer.data.repository.MediaPlayerRepository
import javax.inject.Inject

class GetShortBellUseCase @Inject constructor(private val mediaPlayerRepo: MediaPlayerRepository) {
    operator fun invoke() = mediaPlayerRepo.shortBell()
}