package com.kmm.notes.cache

import com.kmm.notes.entity.Note

interface Database {

    fun getAllNotes(): List<Note>

    fun insertNote(
        title: String,
        body: String
    )

    fun deleteNote(noteId: Long)

    fun getNoteById(noteId: Long): Note?
}
