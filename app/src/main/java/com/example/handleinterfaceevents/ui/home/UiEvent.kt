package com.example.handleinterfaceevents.ui.home

sealed interface UiEvent {
    data object Previous: UiEvent
    data object Save: UiEvent
    data object Next: UiEvent
}