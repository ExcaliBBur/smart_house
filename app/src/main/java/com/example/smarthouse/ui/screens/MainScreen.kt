package com.example.smarthouse.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.smarthouse.R
import com.example.smarthouse.data.devices.AirConditioner
import com.example.smarthouse.data.devices.Light
import com.example.smarthouse.data.devices.Videcam
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.enums.RoomType
import com.example.smarthouse.data.rooms.Room
import com.example.smarthouse.ui.components.RoomsComponent
import com.example.smarthouse.ui.components.templates.CreateTemplateComponent
import com.example.smarthouse.ui.components.templates.DropdownMoreVertTemplate

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(rooms: SnapshotStateList<Room>, onClick: (Room) -> Unit) {
    val dialogOpen = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            Surface(shadowElevation = 5.dp) {
                TopAppBar(
                    title = { Text("Комнаты") },
                    actions = {
                        DropdownMoreVertTemplate {
                            dialogOpen.value = true
                        }
                    },
                )
            }
        },
        content = {
            val suggestions = RoomType.entries.toTypedArray()
            var selectedElement by remember {
                mutableStateOf(RoomType.NONE)
            }
            val kitchenPainter = painterResource(id = R.drawable.kitchen)
            val bedroomPainter = painterResource(id = R.drawable.bedroom)
            val livingRoomPainter = painterResource(id = R.drawable.livingroom)
            val bathroomPainter = painterResource(id = R.drawable.bathroom)
            
            val lightPainter = painterResource(id = R.drawable.light)
            val videcamPainter = painterResource(id = R.drawable.videcam)
            val airConditionerPainter = painterResource(id = R.drawable.air_conditioner)
            
            CreateTemplateComponent(
                onClick = { name ->
                    val room = Room(
                        when (selectedElement) {
                            RoomType.LIVING_ROOM -> livingRoomPainter

                            RoomType.KITCHEN -> kitchenPainter

                            RoomType.BATHROOM -> bathroomPainter

                            RoomType.BEDROOM -> bedroomPainter

                            else -> livingRoomPainter
                        },
                        name,
                        mutableStateListOf(
                            Light(DeviceType.LIGHT, lightPainter, "Свет", false),
                            Videcam(DeviceType.VIDECAM, videcamPainter, "Видеонаблюдение", false),
                            AirConditioner(DeviceType.AIR_CONDITIONER, airConditionerPainter, "Кондиционер", false, 15f)
                        )
                    )
                    rooms.add(room)
                    selectedElement = RoomType.NONE
                },
                dialogOpen = dialogOpen,
                suggestions = suggestions,
                selectedElement = selectedElement,
                getStringValue = { it.translation },
                onValueChange = { selectedElement = it },
                labelName = "Название комнаты",
                labelType = "Тип комнаты"
            )
            Column(
                modifier = Modifier.padding(top = 60.dp)
            ) {
                RoomsComponent(
                    rooms = rooms,
                    onClick = onClick
                )
            }
        }
    )
}