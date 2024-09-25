package com.kmm.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kmm.notes.cache.Database
import com.kmm.notes.cache.DatabaseDriverFactoryImpl
import com.kmm.notes.cache.DatabaseImpl
import com.kmm.notes.entity.Note

class MainActivity : ComponentActivity() {

    /**
     * After spending more than 3 hours trying to inject the viewModel using koin, and tackling one issue after another,
     * I gave up, and I'm initializing the viewModel manually
     */
    private val viewModel: NotesViewModel by lazy {
        NotesViewModel(DatabaseImpl(DatabaseDriverFactoryImpl(this@MainActivity)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NotesScreen(
                Modifier.fillMaxSize(),
                viewModel
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {

    val dummyViewModel = NotesViewModel(object : Database {
        override fun getAllNotes(): List<Note> = listOf()

        override fun insertNote(title: String, body: String) {}

        override fun deleteNote(noteId: Long) {}

        override fun getNoteById(noteId: Long): Note? = null
    })

    //Desperate times call for desperate measures! and sometimes desperate solutions!
    //It's just a preview!
    NotesScreen(
        Modifier.fillMaxSize(),
        dummyViewModel
    )
}
