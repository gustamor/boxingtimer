package es.gustavomoreno.android.boxingtimer.domain

import es.gustavomoreno.android.boxingtimer.data.repository.MediaPlayerRepository
import javax.inject.Inject

class GetLongBellUseCase @Inject constructor(private val mediaPlayerRepo: MediaPlayerRepository) {
    operator fun invoke() = mediaPlayerRepo.longBell()
}

