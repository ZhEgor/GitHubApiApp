package com.example.githubapiapp

import android.app.Application
import com.example.githubapiapp.di.module.dataModule
import com.example.githubapiapp.di.module.useCasesModule
import com.example.githubapiapp.di.module.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(dataModule, useCasesModule, viewModelsModule))
        }
    }
}
