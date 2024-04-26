package com.example.smarthouse.ui.components.devices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.devices.RobotVacuumCleaner

@Composable
fun RobotVacuumCleanerComponent(robotVacuumCleaner: RobotVacuumCleaner) {
    Text(
        text = if (robotVacuumCleaner.status) "Статус: Включен" else "Статус: Выключен",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = robotVacuumCleaner.status,
        onCheckedChange = { robotVacuumCleaner.status = it }
    )
}