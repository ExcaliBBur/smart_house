package com.example.smarthouse.ui.components

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.smarthouse.R
import com.example.smarthouse.data.devices.AirConditioner
import com.example.smarthouse.data.devices.AlarmClock
import com.example.smarthouse.data.devices.Blinds
import com.example.smarthouse.data.devices.CoffeeMachine
import com.example.smarthouse.data.devices.DoorLock
import com.example.smarthouse.data.devices.IrrigationSystem
import com.example.smarthouse.data.devices.Light
import com.example.smarthouse.data.devices.MusicColumn
import com.example.smarthouse.data.devices.RobotVacuumCleaner
import com.example.smarthouse.data.devices.Socket
import com.example.smarthouse.data.devices.Televisor
import com.example.smarthouse.data.devices.Videcam
import com.example.smarthouse.data.enums.Coffee
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.interfaces.Device
import com.example.smarthouse.ui.components.devices.AirConditionerComponent
import com.example.smarthouse.ui.components.devices.AlarmClockComponent
import com.example.smarthouse.ui.components.devices.BlindsComponent
import com.example.smarthouse.ui.components.devices.CoffeeMachineComponent
import com.example.smarthouse.ui.components.devices.DoorLockComponent
import com.example.smarthouse.ui.components.devices.IrrigationSystemComponent
import com.example.smarthouse.ui.components.devices.LightComponent
import com.example.smarthouse.ui.components.devices.MusicColumnComponent
import com.example.smarthouse.ui.components.devices.RobotVacuumCleanerComponent
import com.example.smarthouse.ui.components.devices.SocketComponent
import com.example.smarthouse.ui.components.devices.TelevisorComponent
import com.example.smarthouse.ui.components.devices.VidecamComponent
import com.example.smarthouse.ui.components.templates.CreateTemplateComponent
import com.example.smarthouse.ui.components.templates.DeviceTemplateComponent
import com.example.smarthouse.ui.components.templates.DropdownMoreVertTemplate
import java.time.LocalTime

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RoomDetails(devices: SnapshotStateList<Device>) {
    val dialogOpen = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            Surface(shadowElevation = 5.dp) {
                TopAppBar(
                    title = { Text("Устройства") },
                    actions = {
                        DropdownMoreVertTemplate {
                            dialogOpen.value = true
                        }
                    },
                )
            }
        },
        content = {
            val suggestions = DeviceType.entries.toTypedArray()
            var selectedElement by remember {
                mutableStateOf(DeviceType.NONE)
            }
            val airConditionerPainter = painterResource(id = R.drawable.air_conditioner)
            val alarmClockPainter = painterResource(id = R.drawable.alarm_clock)
            val blindsPainter = painterResource(id = R.drawable.blinds)
            val coffeeMachinePainter = painterResource(id = R.drawable.coffee_machine)
            val doorLockPainter = painterResource(id = R.drawable.door_lock)
            val irrigationSystemPainter = painterResource(id = R.drawable.irrigation_system)
            val lightPainter = painterResource(id = R.drawable.light)
            val musicColumnPainter = painterResource(id = R.drawable.music_column)
            val robotVacuumCleanerPainter = painterResource(id = R.drawable.robot_vacuum_cleaner)
            val socketPainter = painterResource(id = R.drawable.socket)
            val televisorPainter = painterResource(id = R.drawable.television)
            val videcamPainter = painterResource(id = R.drawable.videcam)

            CreateTemplateComponent(
                onClick = { name ->
                    val device = when (selectedElement) {
                        DeviceType.AIR_CONDITIONER -> AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            airConditionerPainter,
                            name,
                            false,
                            15f
                        )
                        
                        DeviceType.ALARM_CLOCK -> AlarmClock(
                            DeviceType.ALARM_CLOCK,
                            alarmClockPainter,
                            name,
                            false,
                            LocalTime.of(15, 30)
                        )
                        
                        DeviceType.BLINDS -> Blinds(
                            DeviceType.BLINDS,
                            blindsPainter,
                            name,
                            false
                        )
                        
                        DeviceType.COFFEE_MACHINE -> CoffeeMachine(
                            DeviceType.COFFEE_MACHINE,
                            coffeeMachinePainter,
                            name,
                            false,
                            Coffee.ESPRESSO,
                            LocalTime.of(15, 30)
                        )
                        
                        DeviceType.DOOR_LOCK -> DoorLock(
                            DeviceType.DOOR_LOCK,
                            doorLockPainter,
                            name,
                            false
                        )
                        
                        DeviceType.IRRIGATION_SYSTEM -> IrrigationSystem(
                            DeviceType.IRRIGATION_SYSTEM,
                            irrigationSystemPainter,
                            name,
                            false,
                            30f
                        )
                        
                        DeviceType.LIGHT -> Light(
                            DeviceType.LIGHT,
                            lightPainter,
                            name,
                            false
                        )
                        
                        DeviceType.MUSIC_COLUMN -> MusicColumn(
                            DeviceType.MUSIC_COLUMN,
                            musicColumnPainter,
                            name,
                            false,
                            30f
                        )
                        
                        DeviceType.ROBOT_VACUUM_CLEANER -> RobotVacuumCleaner(
                            DeviceType.ROBOT_VACUUM_CLEANER,
                            robotVacuumCleanerPainter,
                            name,
                            false,
                        )
                        
                        DeviceType.SOCKET -> Socket(
                            DeviceType.SOCKET,
                            socketPainter,
                            name,
                            false
                        )
                        
                        DeviceType.TELEVISOR -> Televisor(
                            DeviceType.TELEVISOR,
                            televisorPainter,
                            name,
                            false,
                            30f,
                            30f
                        )
                        
                        DeviceType.VIDECAM -> Videcam(
                            DeviceType.VIDECAM,
                            videcamPainter,
                            name,
                            false
                        )
                        
                        else -> Socket(
                            DeviceType.SOCKET, 
                            socketPainter, 
                            name, 
                            true
                        )
                    }
                    devices.add(device)
                    selectedElement = DeviceType.NONE
                },
                dialogOpen = dialogOpen,
                suggestions = suggestions,
                selectedElement = selectedElement,
                getStringValue = { it.translation },
                onValueChange = { selectedElement = it },
                labelName = "Название устройства",
                labelType = "Тип устройства"
            )
            Column(
                modifier = Modifier.padding(top = 60.dp)
            )
            {
                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    devices.forEach { device ->
                        item {
                            DeviceTemplateComponent(
                                deviceType = device.deviceType,
                                initialStatus = device.status,
                                image = device.image,
                                name = device.name,
                                onDelete = { devices.remove(device) },
                                content = {
                                    when (device) {
                                        is AirConditioner -> AirConditionerComponent(airConditioner = device)
                                        is AlarmClock -> AlarmClockComponent(alarmClock = device)
                                        is Blinds -> BlindsComponent(blinds = device)
                                        is CoffeeMachine -> CoffeeMachineComponent(coffeeMachine = device)
                                        is DoorLock -> DoorLockComponent(doorLock = device)
                                        is IrrigationSystem -> IrrigationSystemComponent(
                                            irrigationSystem = device
                                        )
                                        is Light -> LightComponent(light = device)
                                        is MusicColumn -> MusicColumnComponent(musicColumn = device)
                                        is RobotVacuumCleaner -> RobotVacuumCleanerComponent(
                                            robotVacuumCleaner = device
                                        )
                                        is Socket -> SocketComponent(socket = device)
                                        is Televisor -> TelevisorComponent(televisor = device)
                                        is Videcam -> VidecamComponent(videcam = device)
                                    }
                                })
                        }
                    }
                }
            }
        }
    )
}

