package com.example.smarthouse.ui.components.devices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.devices.DoorLock

@Composable
fun DoorLockComponent(doorLock: DoorLock) {
    Text(
        text = if (doorLock.status) "Статус: Открыто" else "Статус: Закрыто",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = doorLock.status,
        onCheckedChange = { doorLock.status = it }
    )
}