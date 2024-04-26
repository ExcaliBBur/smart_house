package com.example.smarthouse.ui.components.devices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.devices.Blinds

@Composable
fun BlindsComponent(blinds: Blinds) {
    Text(
        text = if (blinds.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = blinds.status,
        onCheckedChange = { blinds.status = it }
    )
}