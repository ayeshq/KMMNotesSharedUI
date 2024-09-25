package com.kmm.notes

import com.kmm.notes.cache.DatabaseDriverFactory
import com.kmm.notes.cache.DatabaseDriverFactoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {

    single { androidContext() }

    // Provide DatabaseDriverFactory for Android
    single<DatabaseDriverFactory> { DatabaseDriverFactoryImpl(context = get()) }
}
