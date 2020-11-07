package com.template.app

import android.app.Application
import com.github.jairrab.androidutilities.timberutil.DebugTreeMod
import timber.log.Timber

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTreeMod("^^"))
    }
}