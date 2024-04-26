package com.example.smarthouse.data.rooms

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.painter.Painter
import com.example.smarthouse.data.interfaces.Device

class Room(
    val image: Painter,
    val name: String,
    val devices: SnapshotStateList<Device>
){
    companion object {
        private var currentId = 0
        private fun getNextId() = currentId++
    }

    val id: Int = getNextId()
}

