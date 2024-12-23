package com.example.videocallingapp.connect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.videocallingapp.ui.theme.VideoCallingAppTheme

@Composable
fun ConnectScreen(
    state: connectState,
    onAction: (connectAction) -> Unit
){
Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
){
    Text(
        text = "Choose a name",
        fontSize = 18.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    TextField(
        value = state.name,
        onValueChange = {
            onAction(connectAction.OnNameChange(it))
        },
        placeholder = {
            Text(text = "Name")
        },
        modifier = Modifier
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    if(state.errorMessage != null) {
        Text(
            text = state.errorMessage,
            color = MaterialTheme.colorScheme.error)
    }

    Button(onClick = {
        onAction(connectAction.OnConnectClick)
    },
        modifier = Modifier.align(Alignment.End)
    ) {
        Text(text = "Connect")
    }
}

}
@Preview(showBackground = true)
@Composable
private fun ConnectScreenPreview(){
    VideoCallingAppTheme {
        ConnectScreen(
            state = connectState(
                errorMessage = "Hello world"
            ),
            onAction = {}
        )
    }
}

