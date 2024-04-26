package com.example.smarthouse.ui.components.devices

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthouse.data.devices.CoffeeMachine
import com.example.smarthouse.data.enums.Coffee
import com.example.smarthouse.ui.components.templates.DropdownInputTemplate
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeMachineComponent(coffeeMachine: CoffeeMachine) {
    Text(
        text = if (coffeeMachine.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = coffeeMachine.status,
        onCheckedChange = { coffeeMachine.status = it }
    )

    if (coffeeMachine.status) {
        Text(
            text = "Время начала работы: " + coffeeMachine.time,
            modifier = Modifier.padding(8.dp, 12.dp, 8.dp, 8.dp)
        )

        val clockState = rememberSheetState()
        clockState.visible = false

        ClockDialog(state = clockState,
            config = ClockConfig(
                defaultTime = LocalTime.of(8, 30)
            ),
            selection = ClockSelection.HoursMinutes { hours, minutes ->
                coffeeMachine.time = LocalTime.of(hours, minutes)
            })

        Column {
            Button(
                onClick = {
                    clockState.show()
                }) {
                Text(text = "Установить время")
            }
        }
        DropdownInputTemplate(
            suggestions = Coffee.entries.toTypedArray(),
            selectedElement = coffeeMachine.coffee,
            getStringValue = { it.translation },
            onValueChange = { coffeeMachine.coffee = it },
            label = "Выберите напиток"
        )
    }
}
