package com.example.appka_v3.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onClick: (String) -> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(1.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Home")
        Button( modifier = Modifier
            .width(width = 160.dp)
            .height(height = 60.dp)
            .padding(5.dp),
            onClick = { onClick("detail") }) {
            Text(text = "Detail")
            
        }
        Button( modifier = Modifier
            .width(width = 160.dp)
            .height(height = 60.dp)
            .padding(5.dp),
            onClick = { onClick("settings") }) {
            Text(text = "Settings")
        }
    }
}