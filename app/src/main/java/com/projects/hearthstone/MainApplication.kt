package com.projects.hearthstone

import android.app.Application
import com.projects.core.api.HearthstoneInfoApiService
import com.projects.core.di.coreModule
import com.projects.feature.di.featureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

private val api = HearthstoneInfoApiService

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        api.createInstance()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                coreModule,
                featureModule
            )
        }
    }
}