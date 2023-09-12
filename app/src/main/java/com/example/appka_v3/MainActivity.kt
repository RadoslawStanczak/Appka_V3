package com.example.appka_v3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.appka_v3.ui.theme.Appka_V3Theme


// to jest takie jakby View
class MainActivity : ComponentActivity() {
    private val mainVm by viewModels<MainViewModel>()  // dzięki mainVm uzyskujemy dostęp do klasy MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Appka_V3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val randomNumber = mainVm.modelData.collectAsState()  // obserujemy modelData i zamieniamy StateFlow na State, przy każdej aktualizacji StateFlow wywoła rekompozycję
                    RandomNumberText(number = randomNumber.value) // przyjmujemy wartość Int, a nie StateOfInt
                }
            }
        }
    }
}
@Composable
fun RandomNumberText(number: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Losowa Liczba: $number")
    }
}
