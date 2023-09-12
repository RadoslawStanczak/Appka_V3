package com.example.appka_v3

import kotlin.random.Random


// a to jest Repository
class Repository {
    fun fetchData() : Int {
        val random = Random.nextInt(0,100)
        return random  // funkcja zwraca losowego inta
    }
}