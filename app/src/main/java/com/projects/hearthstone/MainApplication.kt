package com.projects.hearthstone

import android.app.Application
import com.projects.core.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                coreModule
            )
        }
    }
}