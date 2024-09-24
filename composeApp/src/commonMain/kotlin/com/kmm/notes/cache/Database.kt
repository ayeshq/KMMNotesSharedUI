package com.kmm.notes.cache

import com.kmm.notes.entity.Note

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {

    private val database = AppDatabase(databaseDriverFactory.createDriver())

    private val dbQuery = database.appDatabaseQueries

    internal fun getAllNotes(): List<Note> {
        return dbQuery.selectAllNotes { id, title, body ->
            Note(id, title, body)
        }.executeAsList()
    }

    internal fun insertNote(
        title: String,
        body: String
    ) {
        dbQuery.transaction {
            dbQuery.insertNote(title, body)
        }
    }

    internal fun deleteNote(noteId: Long) {
        dbQuery.deleteNoteById(noteId)
    }

    internal fun getNoteById(noteId: Long): Note? {
        return dbQuery.selectNoteById(noteId) { id, title, body ->
            Note(id, title, body)
        }.executeAsOneOrNull()
    }
}
