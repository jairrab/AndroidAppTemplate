package com.template.app.remote.hilt

import com.template.app.remote.ServerApi
import com.template.app.remote.retrofit.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import timber.log.Timber

@Module
@InstallIn(ApplicationComponent::class)
object ServerApiModule {

    @Provides
    fun providesGithubService(): ServerApi {
        val serverApi = RetrofitService.getServerApi()
        Timber.v("ApiClient initialized")
        return serverApi
    }
}