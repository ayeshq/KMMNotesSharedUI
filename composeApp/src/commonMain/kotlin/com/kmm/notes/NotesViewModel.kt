package com.kmm.notes

import androidx.lifecycle.ViewModel
import com.kmm.notes.cache.Database

class NotesViewModel(
    private val database: Database
) : ViewModel() {
}