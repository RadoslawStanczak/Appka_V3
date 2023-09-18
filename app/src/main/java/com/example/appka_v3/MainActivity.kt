package com.example.appka_v3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.appka_v3.ui.theme.Appka_V3Theme
import com.example.appka_v3.ui.theme.screens.DetailScreen
import com.example.appka_v3.ui.theme.screens.HomeScreen
import com.example.appka_v3.ui.theme.screens.SettingsScreen
import com.example.appka_v3.ui.theme.screens.UpdateScreen


// to jest takie jakby View
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Appka_V3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(onClick = {
                                navController.navigate(it) // nawigacja przyjdzie z onClicka z innych plików, bo funkcje zwracają onClicka z argumentem jako string
                            })
                        }

                        composable("detail") {
                            DetailScreen()
                        }
                        composable("settings") {
                            SettingsScreen(onClick = {
                                navController.navigate(
                                    route = it,
                                    navOptions = navOptions {
                                        popUpTo("home") { inclusive = true }
                                    })
                            })
                        }
                        composable("settings") {
                            SettingsScreen(onClick = {
                                navController.navigate("updates")
                            })
                        }
                        composable("updates"){
                            UpdateScreen(onClick = {
                                navController.navigate(
                                    route = it,
                                    navOptions = navOptions {
                                        popUpTo("settings") { inclusive = true }
                                    })
                            })
                        }
                    }
                }
            }
        }
    }
}