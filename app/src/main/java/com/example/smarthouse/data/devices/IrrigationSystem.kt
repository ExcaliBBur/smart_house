package com.example.smarthouse.data.devices

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import com.example.smarthouse.data.enums.DeviceType
import com.example.smarthouse.data.interfaces.Device

class IrrigationSystem(
    initialDeviceType: DeviceType,
    override val image: Painter,
    override val name: String,
    initialStatus: Boolean,
    initialIntencity: Float,
) : Device {
    override val deviceType by mutableStateOf(initialDeviceType)
    override var status by mutableStateOf(initialStatus)
    var intencity by mutableFloatStateOf(initialIntencity)
}