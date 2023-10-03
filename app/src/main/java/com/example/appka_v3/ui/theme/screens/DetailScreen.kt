package com.example.appka_v3.ui.theme.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(){
    Box(modifier = Modifier.fillMaxSize())
    {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .size(width = 300.dp, height = 300.dp)
                .align(Alignment.Center)
        ) {
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .weight(1F),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "ABOUT APP",
                        modifier = Modifier
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(modifier = Modifier
                    .fillMaxSize()
                    .weight(1F),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "Developer: Radek\nCreator: Radek\nDesigner: Radek",
                        modifier = Modifier
                            .padding(16.dp),
                        textAlign = TextAlign.Left,
                        fontSize = 15.sp,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

            }
        }
    }
}

