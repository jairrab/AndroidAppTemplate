package com.template.app.repository.hilt

import com.template.app.remote.GithubApi
import com.template.app.repository.Repository
import com.template.app.repository.implementation.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Provides
    fun providesRepository(githubApi: GithubApi): Repository {
        return RepositoryImpl(githubApi)
    }
}