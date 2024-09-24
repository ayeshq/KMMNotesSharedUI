package com.kmm.notes

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class NotesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NotesApp)
            modules(commonModule, androidModule)
        }
    }
}
