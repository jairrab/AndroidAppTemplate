package com.template.app.model.hilt

import android.app.Application
import com.template.app.model.LocalDb
import com.template.app.model.implementation.LocalDbImpl
import com.template.app.model.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {
    @Provides
    fun providesLocalDb(application: Application): LocalDb {
        val database = AppDatabase.getInstance(application)
        return LocalDbImpl(database)
    }
}