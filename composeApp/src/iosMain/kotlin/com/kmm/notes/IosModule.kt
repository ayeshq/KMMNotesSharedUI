package com.kmm.notes

import com.kmm.notes.cache.DatabaseDriverFactory
import org.koin.dsl.module

val iosModule = module {
    // Provide DatabaseDriverFactory for iOS
    single { DatabaseDriverFactory() }
}