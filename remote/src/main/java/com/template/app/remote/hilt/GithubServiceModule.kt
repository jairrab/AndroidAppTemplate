package com.template.app.remote.hilt

import com.template.app.remote.GithubApi
import com.template.app.remote.retrofit.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object GithubServiceModule {

    @Provides
    fun providesGithubService(): GithubApi {
        return RetrofitService.getApiClient(true)
    }
}