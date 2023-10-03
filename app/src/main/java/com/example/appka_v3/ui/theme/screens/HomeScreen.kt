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
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onClick: (String) -> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(1.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier
            .weight(1F)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Home", fontSize = 30.sp)
        }
        Column(modifier = Modifier
            .weight(1F)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button( modifier = Modifier
                .width(width = 180.dp)
                .height(height = 60.dp)
                .padding(5.dp),
                onClick = { onClick("hackathon") }) {

                Text(text = "Hackathon")
            }

            Button( modifier = Modifier
                .width(width = 180.dp)
                .height(height = 60.dp)
                .padding(5.dp),
                onClick = { onClick("detail") }) {

                Text(text = "Detail", fontSize = 15.sp)

            }
            Button( modifier = Modifier
                .width(width = 180.dp)
                .height(height = 60.dp)
                .padding(5.dp),
                onClick = { onClick("settings") }) {

                Text(text = "Settings", fontSize = 15.sp)
            }
        }


    }
}