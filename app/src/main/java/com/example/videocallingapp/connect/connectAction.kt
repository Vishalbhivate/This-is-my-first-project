package com.example.videocallingapp.connect

sealed interface connectAction {
    data class OnNameChange(val name: String): connectAction
    data object OnConnectClick: connectAction
}