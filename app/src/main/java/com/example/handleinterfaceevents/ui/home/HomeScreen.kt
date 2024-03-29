package com.example.handleinterfaceevents.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = viewModel()

    val listContent = viewModel.listContent.collectAsState()
    val textMessage = viewModel.textMessage

    HomeScreenContent(
        onEvent = { viewModel.onEvent(it) },
        listContent = listContent.value,
        textMessage = textMessage,
    )
}

@Composable
fun HomeScreenContent(
    onEvent: (UiEvent) -> Unit,
    listContent: List<Int>,
    textMessage: String,
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn {
            items(listContent) {
                Card (Modifier.padding(8.dp)) {
                    Text(
                        modifier =  Modifier.padding(8.dp),
                        text = "Item $it"
                    )
                }
            }
        }

        Text(
            modifier = Modifier.padding(8.dp),
            text = textMessage
        )

        Row {

            Button(
                modifier = Modifier.padding(horizontal = 4.dp),
                onClick = { onEvent(UiEvent.Previous) }
            ) {
                Text(text = "Previous")
            }

            Button(
                modifier = Modifier.padding(horizontal = 4.dp),
                onClick = { onEvent(UiEvent.Save) }
            ) {
                Text(text = "Save")
            }

            Button(
                modifier = Modifier.padding(horizontal = 4.dp),
                onClick = { onEvent(UiEvent.Next) }
            ) {
                Text(text = "Next")
            }
        }
    }
}