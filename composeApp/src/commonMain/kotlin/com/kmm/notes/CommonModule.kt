package com.kmm.notes

import com.kmm.notes.cache.Database
import com.kmm.notes.cache.DatabaseImpl
import org.koin.dsl.module

val commonModule = module {

    // Provide Database as DatabaseImpl
    single<Database> { DatabaseImpl(get()) }
}
