package com.example.appka_v3.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun UpdateScreen(onClick: (String) -> Unit){
    var isLoading by remember { mutableStateOf(false) }
    var showText by remember { mutableStateOf(false) }
    var messageVersion by remember { mutableStateOf(false)}
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier
            .weight(1F)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Text(text = "Check for updates")
            }
            Row {
                Button(modifier = Modifier
                    .width(width = 160.dp)
                    .height(height = 60.dp)
                    .padding(5.dp),
                    onClick = {
                        CoroutineScope(MainScope().coroutineContext).launch {
                            isLoading = true
                            delay(timeMillis = 3000)
                            isLoading = false
                            showText = true
                            delay(timeMillis = 2000)
                            showText = false
                            delay(2000)
                            messageVersion = true
                        }
                    }) {
                    Text("Update")
                }
            }
        }

        Row(modifier = Modifier
            .weight(1F)// Dynamiczna wysokość w zależności od isLoading
            .padding(25.dp),
            verticalAlignment = Alignment.CenterVertically) {
            when {
                isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp)
                    )
                }

                showText -> {
                    Text("Everything is up-to-date")
                }

                messageVersion -> {
                    Text(text = "Current version 3.0")
                }
            }
        }
    }
}