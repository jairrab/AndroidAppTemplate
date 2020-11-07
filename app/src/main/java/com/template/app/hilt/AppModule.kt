package com.template.app.hilt

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
}