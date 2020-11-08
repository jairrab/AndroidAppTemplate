package com.template.app.remote.hilt

import com.template.app.remote.RemoteApi
import com.template.app.remote.retrofit.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import timber.log.Timber

@Module
@InstallIn(ApplicationComponent::class)
object RemoteApiModule {
    @Provides
    fun providesRemoteApi(): RemoteApi {
        val remoteApi = RetrofitService.getRemoteApi()
        Timber.v("ApiClient initialized")
        return remoteApi
    }
}