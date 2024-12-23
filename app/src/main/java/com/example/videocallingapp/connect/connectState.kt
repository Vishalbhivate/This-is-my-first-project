package com.example.videocallingapp.connect

import io.getstream.video.android.core.socket.SocketState

data class connectState(
    val name: String = "",
    val isConnected: Boolean = false,
    val errorMessage: String? = null
)
