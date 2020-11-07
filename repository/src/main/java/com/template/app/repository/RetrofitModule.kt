package com.template.app.repository

import com.template.app.remote.GithubService
import com.template.app.remote.RetrofitService
import com.template.app.repository.implementation.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Provides
    fun providesGithubService(): GithubService {
        return RetrofitService.getApiClient(true)
    }

    @Provides
    fun providesRepository(githubService: GithubService): Repository {
        return RepositoryImpl(githubService)
    }
}