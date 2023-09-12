package com.example.appka_v3

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.concurrent.fixedRateTimer


// to jest takie jakby ViewModel, który wystawia dane dla View który je wyświetla
class MainViewModel : ViewModel() {
    private val repo = Repository() // tworzymy instancję klasy Repository, żeby mieć dostęp do funkcji fetchData
    private val _modelData = MutableStateFlow(0)  // zmienna prywatna i mutowalna (edytowalna). Można zmieniać wyłącznie z poziomu main activity
    val modelData = _modelData.asStateFlow()  // zmienna publiczna i niemutowalna jest tylko do odczytu obserwujemy ją, wskazuje ona na _modelData

    init {
        makeNetworkRequestPeriodic()
    }
    private fun makeNetworkRequestPeriodic(){
        fixedRateTimer(period = 1000L){ // co sekunde wykonuje zapytanie
            val randomNumber = repo.fetchData() // przyjmuje wartość funkcji fetchData() czyli kolejną randomową cyfrę
            _modelData.update { randomNumber } // updatujemy _modelData o nową cyfrę
        }
    }
}