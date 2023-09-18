package com.example.appka_v3.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(onClick: (String) -> Unit){
    var enabled by remember{  // dla przycisku disableButton
        mutableStateOf(true)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(1.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Settings")
        Button(modifier = Modifier
            .width(width = 160.dp)
            .height(height = 60.dp)
            .padding(5.dp),
            onClick = { onClick("home") }) {
            Text(text = "Home")
        }
        Button( modifier = Modifier
            .width(width = 160.dp)
            .height(height = 60.dp)
            .padding(5.dp),
            onClick = {
                enabled = !enabled  // jeśli enabled to zrób enabled = false i na odwrót
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (enabled) MaterialTheme.colorScheme.surfaceTint else Color.Gray,  // kolor przycisku
                contentColor = if (enabled) MaterialTheme.colorScheme.inverseOnSurface else Color.DarkGray)  // kolor textu w przycisku
            ) {
                Text(text = "Jakość HD")
            }
        Button(modifier = Modifier
            .width(width = 180.dp)
            .height(height = 60.dp)
            .padding(5.dp),
            onClick = { onClick("updates") }) {
                Text(text = "Check for updates")
        }
        }
}