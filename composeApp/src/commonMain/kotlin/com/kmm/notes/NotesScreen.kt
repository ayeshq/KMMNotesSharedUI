package com.kmm.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun NotesScreen(
    modifier: Modifier,
    viewModel: NotesViewModel
) {
    val onAddNoteClick: () -> Unit = {

    }


    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Notes") }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = onAddNoteClick) {
                    Icon(Icons.Default.Add, contentDescription = "Add Note")
                }
            },
            content = { innerPadding ->
                // Placeholder for the screen content
                Box(
                    modifier = modifier
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No notes yet, create a new note by pressing the button below!",
                        textAlign = TextAlign.Center
                    )
                }
            }
        )


//        var showContent by remember { mutableStateOf(false) }
//        Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
    }
}