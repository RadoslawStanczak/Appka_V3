package com.example.appka_v3.ui.theme.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appka_v3.R

data class PlaceData(
    val name: String,
    val description: String,
    val location: String,
    val imageUrl: String,
    var wybrane: Boolean
)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HackathonScreen(onClick: (String) -> Unit) {
    var progress by remember { mutableFloatStateOf(0f) }  // początkowa wartość progress baru
    var placeData by remember { mutableStateOf(PlaceData("", "", "", "", wybrane = true)) }
    val places = listOf("ZOO Płock", "Katedra Płock", "Stadion Orlen", "Molo", "Muzeum", "Muzeum Żydów", "Tumska")  // lista elementów tymczasowo, potem będziemy przechodzić po indexach w bazie danych
    var currentIndex by remember { mutableIntStateOf(0) }
    var nextButtonClicked by remember { mutableStateOf(false) }
    var addButtonClicked by remember { mutableStateOf(false) }
    var buttonEnabled by remember { mutableStateOf(true)}
    val wybrane by remember { mutableStateOf(false)}


    fun fetchPlaceData(placeName: String, wybrane: Boolean, ) {

        // Można dodać więcej warunków lub pobrać dane z bazy na podstawie placeName
        when (placeName) {
            "ZOO Płock" -> {
                placeData = PlaceData(
                    name = "ZOO Płock",
                    description = "Tu żyją zwierzaczki",
                    location = "Płock",
                    imageUrl = "url_zdjecia_zoo",
                    wybrane = wybrane
                )
            }
            "Katedra Płock" -> {
                placeData = PlaceData(
                    name = "Katedra Płock",
                    description = "Drugi dom papaja",
                    location = "Płock",
                    imageUrl = "url_zdjecia_katedra",
                    wybrane = wybrane
                )
            }
            "Stadion Orlen" -> {
                placeData = PlaceData(
                    name= "Stadion Orlen",
                    description = "Tutaj kopacze kapią",
                    location = "Płock",
                    imageUrl = "url_zdjecia_stadion",
                    wybrane = wybrane
                )
            }
            "Molo" -> {
                placeData = PlaceData(
                    name= "Molo",
                    description = "Tutaj ryby skaczą",
                    location = "Płock",
                    imageUrl = "url_zdjecia_molo",
                    wybrane = wybrane
                )
            }
            "Muzeum" -> {
                placeData = PlaceData(
                    name= "Muzum Mazowieckie",
                    description = "Tutaj korniki drapią",
                    location = "Płock",
                    imageUrl = "url_zdjecia_muzeum",
                    wybrane = wybrane
                )
            }
            "Muzeum Żydów" -> {
                placeData = PlaceData(
                    name= "Muzum Żydów",
                    description = "Tutaj palono w piecu",
                    location = "Płock",
                    imageUrl = "url_zdjecia_muzeum_zydow",
                    wybrane = wybrane
                )
            }
            "Tumska" -> {
                placeData = PlaceData(
                    name= "Ulica Tumska",
                    description = "Tutaj to chuj wie",
                    location = "Płock",
                    imageUrl = "url_zdjecia_tumska",
                    wybrane = wybrane
                )
            }
            // Więcej przypadków dla innych miejsc
            else -> {
                // Domyślne ustawienia dla nieznanych miejsc
                placeData = PlaceData(
                    name = "Inne miejsce",
                    description = "Opis innego miejsca",
                    location = "Gdzieś",
                    imageUrl = "url_zdjecia_inne",
                    wybrane = wybrane
                )
            }
        }
    }

    fun nextPlace() {
//        if(currentIndex < 1){
//            val previousIndex = currentIndex
//            if(addButtonClicked){
//                fetchPlaceData(places[previousIndex], wybrane = true)
//            }
//            else {
//                fetchPlaceData(places[previousIndex], wybrane = false)
//            }
//        }
//        else{
//            val previousIndex = currentIndex -1
//        }

            // Zaktualizuje currentIndex
            currentIndex = (currentIndex + 1) % places.size

            // Aktualizuje dane dla bieżącego miejsca
            fetchPlaceData(places[currentIndex], wybrane)

            // Dodaje warunek, żeby aktualizować progress tylko dla przycisku "Dodaj"
            if (addButtonClicked && !nextButtonClicked && progress < 1.0f) {
                progress += 0.2f
                if(progress == 1f){
                    buttonEnabled = false

                }
            }
            nextButtonClicked = false
    }

    // funkcja do zmiany zdjęć
    @Composable
    fun loadImageForCurrentPlace(): Painter {
        // Pobiera aktualny URL obrazka dla bieżącego miejsca
        val imageUrl = placeData.imageUrl

        // Sprawdza który obrazek ma być wyświetlony i zwróć odpowiedni Painter
        return when (imageUrl) {
            "url_zdjecia_zoo" -> painterResource(id = R.drawable.zoo) // Podaj właściwe ID dla obrazka ZOO
            "url_zdjecia_katedra" -> painterResource(id = R.drawable.katedra) // Podaj właściwe ID dla obrazka Katedra
            "url_zdjecia_stadion" -> painterResource(id = R.drawable.stadion)
            "url_zdjecia_molo" -> painterResource(id = R.drawable.molo)
            "url_zdjecia_muzeum" -> painterResource(id = R.drawable.muzeum)
            "url_zdjecia_muzeum_zydow" -> painterResource(id = R.drawable.muzeum_zydow)
            "url_zdjecia_tumska" -> painterResource(id = R.drawable.tumska)
            // Inne przypadki dla innych miejsc, jeśli są
            else -> painterResource(id = R.drawable.papaj) // Domyślny obrazek, jeśli URL jest nieznany
        }
    }

    @Composable
    fun getFooterTextForCurrentPlace(): String {
        return when (places[currentIndex]) {
            "ZOO Płock" -> "Najbliższy kibel: ul. Zoofilna"
            "Katedra Płock" -> "Najbliższy kibel: ul. Katedralna"
            "Stadion Orlen" -> "Najbliższy kibel: ul. Patałachów"
            "Molo" -> "Najbliższy kibel: jest pod wodą"
            "Muzeum" -> "Najbliższy kibel: Za obrazem Stańczyka"
            "Muzeum_zydow" -> "Najbliższy kibel: Jest dziura w ziemi"
            "Tumska" -> "Najbliższy kibel: Żabka 25a"
            // Inne przypadki dla innych miejsc
            else -> "Najbliższy kibel: Chuj wie \uD83D\uDD95"
        }
    }
    fetchPlaceData("ZOO Płock", wybrane = false) // Domyślne miejsce po uruchomieniu


    // górna część ekranu aplikacji
    BottomSheetScaffold(
        sheetContent = {
            Footer(getFooterTextForCurrentPlace())  // przekazanie danych, w tym przypadku to co zwraca funkcja getFooterTextForCurrentPlace()
        },
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetPeekHeight = BottomSheetScaffoldDefaults.SheetPeekHeight,

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            // Progress bar (15% wysokości ekranu)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.15f)
                    .padding(16.dp)
            ) {
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }

            // ElevatedCard (60% wysokości ekranu)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f)
                    .padding(16.dp)
            ) {
                ElevatedCard(colors = CardDefaults.cardColors(
                    containerColor = if (placeData.wybrane && buttonEnabled) Color.Green  else MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    // Zawartość ElevatedCard
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Column(modifier = Modifier
                            .fillMaxSize()
                            .weight(1F),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(modifier = Modifier
                                .fillMaxSize()
                            ){
                                Image(
                                    painter = loadImageForCurrentPlace(), // tutaj podaj ID zasobu obrazka
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop, // dostosuj w razie potrzeby
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)  // Ustaw wysokość zdjęcia według potrzeb
                                )
                                Text(
                                    text = places[currentIndex],
                                    style = TextStyle.Default.copy(
                                        drawStyle = Stroke(
                                            miter = 10f,
                                            width = 4f,
                                            join = StrokeJoin.Round
                                        )
                                    ),
                                    modifier = Modifier
                                        .padding(16.dp),
                                    textAlign = TextAlign.Center,
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        Column(modifier = Modifier
                            .fillMaxSize()
                            .weight(1F),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally) {


                            Text(
                                text = placeData.description,
                                modifier = Modifier
                                    .padding(16.dp),
                                textAlign = TextAlign.Left,
                                fontSize = 15.sp,
                            )
                            Text(
                                text = placeData.location,
                                modifier = Modifier
                                    .padding(16.dp),
                                textAlign = TextAlign.Left,
                                fontSize = 15.sp,
                            )
                        }
                    }
                }
            }

            // Row (25% wysokości ekranu)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.25f)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .width(width = 180.dp)
                            .height(height = 60.dp)
                            .padding(5.dp),
                        enabled = buttonEnabled,
                        onClick = {
                            nextButtonClicked = true
                            nextPlace() // następny element listy
                        }
                    ) {
                        Text(text = "Następne", fontSize = 15.sp)
                    }


                    OutlinedButton(
                        modifier = Modifier
                            .width(width = 180.dp)
                            .height(height = 60.dp)
                            .padding(5.dp),
                        enabled = buttonEnabled,
                        onClick = {
                            addButtonClicked = true
                            //wybrane = true
                            nextPlace() // następny element listy


                        }
                    ) {
                        Text(text = "Dodaj", fontSize = 15.sp)
                    }
                }
            }
        }
    }
}

// wysuwany komponent na dole ekranu
@Composable
fun Footer(footerText: String){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .height(BottomSheetScaffoldDefaults.SheetPeekHeight)
        ) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowUp, // strzałka do zaznaczenia gdzie jest handler
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        // wnętrze komponentu wysuwanego, ulega rekompozycji po dodaniu lub pominięciu miejsca
        Text(text = "Kibel \uD83D\uDEBD")
        Text(text = footerText)  // lokalizacja kibla
        Spacer(modifier = Modifier.padding(bottom = 30.dp))  // odległość dolengo elementu od dolnej krawędzi ekranu
    }
}

