package com.template.app.hilt

import android.content.Context
import com.github.jairrab.androidutilities.utility.AndroidUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {
    @Provides
    @ActivityScoped
    fun providesAndroidUtility(@ActivityContext context: Context): AndroidUtility {
        return AndroidUtility.getInstance(context)
    }
}