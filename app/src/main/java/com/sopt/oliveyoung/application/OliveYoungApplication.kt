package com.sopt.oliveyoung.application

import android.app.Application
import com.sopt.oliveyoung.BuildConfig
import com.sopt.oliveyoung.util.OliveYoungDebugTree
import timber.log.Timber

class OliveYoungApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(OliveYoungDebugTree())
        }
    }
}