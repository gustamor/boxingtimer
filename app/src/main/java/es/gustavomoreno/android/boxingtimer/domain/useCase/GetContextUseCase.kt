package es.gustavomoreno.android.boxingtimer.domain.useCase

import es.gustavomoreno.android.boxingtimer.data.repository.ContextRepository
import javax.inject.Inject

class GetContextUseCase @Inject constructor(private val context: ContextRepository){
    operator fun invoke() = context.get()
}