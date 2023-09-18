package com.example.appka_v3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.appka_v3.ui.theme.screens.DetailScreen
import com.example.appka_v3.ui.theme.screens.HomeScreen
import com.example.appka_v3.ui.theme.screens.SettingsScreen


// to jest takie jakby View
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home" ){
                composable("home"){
                    HomeScreen(onClick = {
                        navController.navigate(it) // nawigacja przyjdzie z onClicka z innych plików, bo funkcje zwracają onClicka z argumentem jako string
                    })
                }
                
                composable("detail"){
                    DetailScreen()
                }
                composable("settings"){
                    SettingsScreen(onClick = {
                        navController.navigate(
                            route = it,
                            navOptions = navOptions {
                                popUpTo("home"){ inclusive = true }
                        })
                    })
                }
            }

        }
    }


}