package es.gustavomoreno.android.boxingtimer.data.di

import android.content.Context
import android.media.MediaPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.gustavomoreno.android.boxingtimer.R


@Module
@InstallIn(SingletonComponent::class)
class MediaPlayerModule {

    @Provides
    fun providesMediaPlayer() =  MediaPlayer()

}