package com.template.app

import android.app.Application
import com.github.jairrab.androidutilities.timberutil.DebugTreeMod
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTreeMod("^^"))
    }
}