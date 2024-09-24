package com.kmm.notes

import android.content.Context
import com.kmm.notes.cache.DatabaseDriverFactoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {

    single { androidContext() as Context }

    // Provide DatabaseDriverFactory for Android
    single { DatabaseDriverFactoryImpl(get()) } // The context will be provided from Android
}
