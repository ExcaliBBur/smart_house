package com.example.smarthouse.ui.components.devices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.devices.AirConditioner
import com.example.smarthouse.ui.theme.Purple10
import kotlin.math.roundToInt

@Composable
fun AirConditionerComponent(airConditioner: AirConditioner) {
    Text(
        text = if (airConditioner.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = airConditioner.status,
        onCheckedChange = { airConditioner.status = it }
    )

    if (airConditioner.status) {
        Text(
            text = "Температура: " + airConditioner.temperature.toString() + "°C",
            modifier = Modifier.padding(8.dp, 12.dp, 8.dp, 8.dp)
        )
        Slider(
            value = airConditioner.temperature,
            onValueChange = { airConditioner.temperature = (it * 10).roundToInt() / 10f },
            valueRange = 0f..30f,
            steps = 200,
            colors = SliderDefaults.colors(
                activeTrackColor = Purple10,
                activeTickColor = Purple10
            )
        )
    }
}