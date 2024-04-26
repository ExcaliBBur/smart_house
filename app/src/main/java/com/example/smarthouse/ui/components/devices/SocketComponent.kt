package com.example.smarthouse.ui.components.devices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.devices.Socket

@Composable
fun SocketComponent(socket: Socket) {
    Text(
        text = if (socket.status) "Статус: Включена" else "Статус: Выключена",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = socket.status,
        onCheckedChange = { socket.status = it }
    )
}