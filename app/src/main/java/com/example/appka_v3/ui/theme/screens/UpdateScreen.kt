package com.example.appka_v3.ui.theme.screens

import android.content.Context.VIBRATOR_SERVICE
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun UpdateScreen(onClick: (String) -> Unit){
    var isLoading by remember { mutableStateOf(false) }
    var showText by remember { mutableStateOf(false) }
    var messageVersion by remember { mutableStateOf(false)}
    var whenRunning by remember { mutableStateOf(true )}
    val context = LocalContext.current
    val vibrator = context.getSystemService(VIBRATOR_SERVICE) as Vibrator?
    // Długość wibracji w milisekundach
    val vibrationDuration = 30L
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier
            .weight(1F)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Column(modifier = Modifier
                .weight(1F)
                .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "Check for updates", fontSize = 30.sp)
                }
            Column(modifier = Modifier
                .weight(1F)
                .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .width(width = 180.dp)
                    .height(height = 60.dp)
                    .padding(5.dp),
                    enabled = whenRunning, // enabled po prawej to zmienna
                    onClick = {
                        CoroutineScope(MainScope().coroutineContext).launch {
                            whenRunning = false
                            isLoading = true
                            delay(timeMillis = 3000)
                            isLoading = false
                            showText = true
                            delay(timeMillis = 2000)
                            showText = false
                            messageVersion = true
                            delay(timeMillis = 1000)
                            Toast.makeText(context, "Done!", Toast.LENGTH_SHORT).show()
                            if (vibrator?.hasVibrator() == true) {
                                // Utwórz efekt wibracji
                                val vibrationEffect = VibrationEffect.createOneShot(vibrationDuration, VibrationEffect.DEFAULT_AMPLITUDE)

                                // Wywołaj wibrację
                                vibrator.vibrate(vibrationEffect)
                            }
                            whenRunning = true
                        }
                    }
                ) {
                    Text("Update", fontSize = 15.sp)
                }
            }
        }

        Column(modifier = Modifier
            .weight(1F)// Dynamiczna wysokość w zależności od isLoading
            .padding(25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            when {
                isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(30.dp)
                    )
                }

                showText -> {
                    Text("Everything is up-to-date", fontSize = 15.sp)
                }

                messageVersion -> {
                    Text(text = "Current version 3.5", fontSize = 15.sp)
                }

            }
        }
    }
}