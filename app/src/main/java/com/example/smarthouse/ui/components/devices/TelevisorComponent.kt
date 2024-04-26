package com.example.smarthouse.ui.components.devices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.devices.Televisor

@Composable
fun TelevisorComponent(televisor: Televisor) {
    Text(
        text = if (televisor.status) "Статус: Включен" else "Статус: Выключен",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = televisor.status,
        onCheckedChange = { televisor.status = it }
    )

    if (televisor.status) {
        Text(
            text = "Яркость: " + televisor.brightness + "%",
            modifier = Modifier.padding(8.dp, 12.dp, 8.dp, 8.dp)
        )
        Slider(
            value = televisor.brightness,
            onValueChange = { televisor.brightness = it },
            valueRange = 0f..100f,
            steps = 200,
//            colors = SliderDefaults.colors(
//                activeTrackColor = Purple10,
//                activeTickColor = Purple10
//            )
        )
        Text(
            text = "Звук: " + televisor.volume + "%",
            modifier = Modifier.padding(8.dp, 12.dp, 8.dp, 8.dp)
        )
        Slider(
            value = televisor.volume,
            onValueChange = { televisor.volume = it },
            valueRange = 0f..100f,
            steps = 200,
//            colors = SliderDefaults.colors(
//                activeTrackColor = Purple10,
//                activeTickColor = Purple10
//            )
        )
    }
}