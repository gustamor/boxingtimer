package es.gustavomoreno.android.boxingtimer.data.repository

import android.content.Context
import javax.inject.Inject

class ContextRepository @Inject constructor(private val context: Context) {
    fun get() = context
}