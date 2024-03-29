package com.example.handleinterfaceevents.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {

    private val dummyList = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    private val _listContent = MutableStateFlow(dummyList)
    val listContent: StateFlow<List<Int>> = _listContent.asStateFlow()

    var textMessage by mutableStateOf("")
        private set

    fun onEvent(event: UiEvent) {
        when(event) {

            is UiEvent.Previous -> {
                // Handle Previous button click
                textMessage = "Previous!"
            }
            is UiEvent.Save -> {
                textMessage = "Saved!"
                saveData()
            }
            is UiEvent.Next -> {
                // Handle Next button click
                textMessage = "Next!"
            }
        }
    }

    private fun saveData() {}

}