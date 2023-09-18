package com.example.appka_v3.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
        Button(onClick = { onClick("detail") }) {
            Text(text = "Detail")
            
        }
        Button(onClick = { onClick("settings") }) {
            Text(text = "Settings")
        }
    }
}