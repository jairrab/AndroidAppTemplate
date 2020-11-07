package com.template.app.repository.hilt

import com.template.app.repository.Repository
import com.template.app.repository.implementation.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RetrofitModule {

    @Binds
    abstract fun bindViewModelFactory(repositoryImpl: RepositoryImpl): Repository
}