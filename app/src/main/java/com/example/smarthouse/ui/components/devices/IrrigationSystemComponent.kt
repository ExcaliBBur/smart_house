package com.example.smarthouse.ui.components.devices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.devices.IrrigationSystem

@Composable
fun IrrigationSystemComponent(irrigationSystem: IrrigationSystem) {
    Text(
        text = if (irrigationSystem.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = irrigationSystem.status,
        onCheckedChange = { irrigationSystem.status = it }
    )

    if (irrigationSystem.status) {
        Text(
            text = "Интенсивность: " + irrigationSystem.intencity + "%",
            modifier = Modifier.padding(8.dp, 12.dp, 8.dp, 8.dp)
        )
        Slider(
            value = irrigationSystem.intencity,
            onValueChange = { irrigationSystem.intencity = it },
            valueRange = 0f..100f,
            steps = 200,
//            colors = SliderDefaults.colors(
//                activeTrackColor = Purple10,
//                activeTickColor = Purple10
//            )
        )
    }
}