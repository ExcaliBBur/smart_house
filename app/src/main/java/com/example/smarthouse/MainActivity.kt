package com.example.smarthouse

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarthouse.data.devices.AirConditioner
import com.example.smarthouse.data.devices.AlarmClock
import com.example.smarthouse.data.devices.CoffeeMachine
import com.example.smarthouse.data.devices.Light
import com.example.smarthouse.data.devices.Videcam
import com.example.smarthouse.data.enums.Coffee
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.rooms.Room
import com.example.smarthouse.ui.screens.MainScreen
import com.example.smarthouse.ui.screens.RoomScreen
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val lightPainter = painterResource(id = R.drawable.light)
            val alarmClockPainter = painterResource(id = R.drawable.alarm_clock)
            val coffeeMachinePainter = painterResource(id = R.drawable.coffee_machine)
            val conditionerPainter = painterResource(id = R.drawable.air_conditioner)
            val videcamPainter = painterResource(id = R.drawable.videcam)

            val livingRoom = Room(
                painterResource(id = R.drawable.livingroom),
                "Зал",
                remember {
                    mutableStateListOf(
                        AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            conditionerPainter,
                            name = "Кондиционер",
                            false,
                            initialTemperature = 10.0f
                        ),
                        Light(DeviceType.LIGHT, lightPainter, "Свет", true),
                        Videcam(DeviceType.VIDECAM, videcamPainter, "Видеонаблюдение", true),
                    )
                }
            )
            val bedroom = Room(
                painterResource(id = R.drawable.bedroom),
                "Спальня",
                remember {
                    mutableStateListOf(
                        AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            conditionerPainter,
                            name = "Кондиционер",
                            true,
                            initialTemperature = 10.0f
                        ),
                        Light(DeviceType.LIGHT, lightPainter, "Свет", true),
                        AlarmClock(
                            DeviceType.ALARM_CLOCK,
                            alarmClockPainter,
                            "Будильник",
                            true,
                            LocalTime.of(8, 30)
                        ),
                        Videcam(DeviceType.VIDECAM, videcamPainter, "Видеонаблюдение", true),

                    )
                }
            )
            val kitchen = Room(
                painterResource(id = R.drawable.kitchen),
                "Кухня",
                remember {
                    mutableStateListOf(
                        AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            conditionerPainter,
                            name = "Кондиционер",
                            false,
                            initialTemperature = 10.0f
                        ),
                        Light(DeviceType.LIGHT, lightPainter, "Свет", true),
                        CoffeeMachine(
                            DeviceType.COFFEE_MACHINE,
                            coffeeMachinePainter,
                            "Кофемашина",
                            true,
                            Coffee.NONE,
                            LocalTime.of(8, 30)
                        ),
                        Videcam(DeviceType.VIDECAM, videcamPainter, "Видеонаблюдение", true),

                    )
                }
            )
            val rooms = remember {
                mutableStateListOf(livingRoom, bedroom, kitchen)
            }
            val navController = rememberNavController()
            val mainScreen = "main"
            NavHost(
                navController = navController,
                startDestination = mainScreen
            ) {
                composable(mainScreen) {
                    MainScreen(rooms = rooms) { room ->
                        val route = "room/${room.id}"
                        navController.navigate(route)
                    }
                }
                repeat(100) { index ->
                    val route = "room/${index}"
                    composable(route = route) {
                        RoomScreen(room = rooms[index])
                    }
                }
            }
        }
    }
}