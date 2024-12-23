package com.example.videocallingapp.connect

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.videocallingapp.VideoCallingApp


class connectViewModel(
    private val app: Application
): AndroidViewModel(app) {

    var state by mutableStateOf(connectState())
        private set

    fun onAction(action: connectAction) {
        when (action) {
            connectAction.OnConnectClick -> {
                connectToRoom()

            }
            is connectAction.OnNameChange -> {
                state = state.copy(name = action.name)

            }
        }
    }
private fun connectToRoom(){
    state = state.copy(errorMessage = null)
    if(state.name.isBlank()) {
        state = state.copy(
            errorMessage = "The username can't be blank."
        )
        return
    }
    (app as VideoCallingApp).initVideoClient(state.name)

    state = state.copy(isConnected = true)
}
}
