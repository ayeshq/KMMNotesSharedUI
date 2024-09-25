package com.kmm.notes.cache

import com.kmm.notes.entity.Note

class DatabaseImpl(
    databaseDriverFactory: DatabaseDriverFactory
) : Database {

//    private val appDatabase = AppDatabase(databaseDriverFactory.createDriver())

    private val appDatabase by lazy {
        AppDatabase(databaseDriverFactory.createDriver())
    }

    private val dbQuery = appDatabase.appDatabaseQueries

    override fun getAllNotes(): List<Note> {
        return dbQuery.selectAllNotes { id, title, body ->
            Note(id, title, body)
        }.executeAsList()
    }

    override fun insertNote(
        title: String,
        body: String
    ) {
        dbQuery.transaction {
            dbQuery.insertNote(title, body)
        }
    }

    override fun deleteNote(noteId: Long) {
        dbQuery.deleteNoteById(noteId)
    }

    override fun getNoteById(noteId: Long): Note? {
        return dbQuery.selectNoteById(noteId) { id, title, body ->
            Note(id, title, body)
        }.executeAsOneOrNull()
    }
}