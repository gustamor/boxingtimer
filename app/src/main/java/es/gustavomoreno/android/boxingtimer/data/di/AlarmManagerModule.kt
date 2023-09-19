package es.gustavomoreno.android.boxingtimer.data.di

import android.app.AlarmManager
import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AlarmManagerModule {
    @Provides

    fun provideAlarmManager(application: Application): AlarmManager = application.getSystemService(Context.ALARM_SERVICE) as AlarmManager

}