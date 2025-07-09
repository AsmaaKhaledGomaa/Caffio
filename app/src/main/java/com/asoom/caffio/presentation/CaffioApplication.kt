package com.asoom.caffio.presentation

import android.app.Application
import com.asoom.caffio.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CaffioApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CaffioApplication)
            modules(viewModelModule)
        }
    }
}