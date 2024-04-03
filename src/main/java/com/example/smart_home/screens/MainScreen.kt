package com.example.smart_home.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smart_home.R
import com.example.smart_home.ui.theme.DarkGray


@Composable
fun MainCard() {
    Row {
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Умный дом",
            style = TextStyle(fontSize = 15.sp),
            color = Color.White
        )

    }

}

@Preview(showBackground = true)
@Composable
fun ListItem() {
    Card(
        modifier = Modifier.padding(100.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Image(
                painter = painterResource(id = R.drawable.lamp),
                contentDescription = "lamp"
            )
            Text(
                text = "Люстра",
                color = Color.White
            )
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_toggle_on_24),
                        contentDescription = "toggle_on",
                        tint = Color.White
                    )
                }
            }
        }
    }
}