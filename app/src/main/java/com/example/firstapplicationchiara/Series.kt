package com.example.firstapplicationchiara

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import coil.compose.AsyncImage

/**
 * Composable pour afficher une grille de series.
 *
 * Fonctionnalités :
 * - Adapte le nombre de colonnes de la grille en fonction de la taille de l'écran.
 * - Récupère la liste des series via le ViewModel lors de la composition.
 * - Affiche chaque serie avec une carte contenant l'affche, le nom et la date de sortie.
 *
 * Paramètres :
 * @param viewmodel - Le ViewModel utilisé pour accéder à la liste des acteurs.
 * @param windowSizeClass - Classe de taille d'écran utilisée pour déterminer le nombre de colonnes de la grille nécessaire.
 * @param navController - Contrôleur de navigation pour gérer les transitions entre les écrans.
 */
@Composable
fun DescSeries(navController: NavHostController, viewmodel: MainViewModel,  windowSizeClass: WindowSizeClass) {
    val series by viewmodel.series.collectAsState()
    var serieId: Int

    val columns = when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 2
        WindowWidthSizeClass.MEDIUM -> 3
        WindowWidthSizeClass.EXPANDED -> 4
        else -> 2
    }


    LaunchedEffect(true) {
        viewmodel.getSeries()
    }


    LazyVerticalGrid(columns = GridCells.Fixed(columns)) {

        items(series) { serie ->
            Column {
                ElevatedCard(onClick = {
                    serieId = serie.id
                    navController.navigate(Serie(serieId.toString()))
                },
                    elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                    modifier = Modifier
                        .size(width = 200.dp, height = 375.dp)
                        .padding(8.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color(0xFFD2B48C)
                    )) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w780/" + serie.poster_path,
                        contentDescription = "films"
                    )
                    Text(
                        text = serie.name,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    // Date de sortie
                    Text(
                        text = serie.first_air_date,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }

}
