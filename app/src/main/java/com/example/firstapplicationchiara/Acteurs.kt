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
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import coil.compose.AsyncImage


/**
 * Composable pour afficher une grille d'acteurs.
 *
 * Fonctionnalités :
 * - Adapte le nombre de colonnes de la grille en fonction de la taille de l'écran.
 * - Récupère la liste des acteurs via le ViewModel lors de la composition.
 * - Affiche chaque acteur avec une carte contenant une image, le nom et le prénom.
 *
 * Paramètres :
 * @param viewmodel - Le ViewModel utilisé pour accéder à la liste des acteurs.
 * @param windowSizeClass - Classe de taille d'écran utilisée pour déterminer le nombre de colonnes de la grille nécessaire.
 */

@Composable
fun DescActeurs(viewmodel: MainViewModel, windowSizeClass: WindowSizeClass) {
    val acteurs by viewmodel.acteurs.collectAsState()

    val columns = when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 2
        WindowWidthSizeClass.MEDIUM -> 3
        WindowWidthSizeClass.EXPANDED -> 4
        else -> 2
    }


    LaunchedEffect(true) {
        viewmodel.getActeurs()
    }


    LazyVerticalGrid(columns = GridCells.Fixed(columns)) {

        items(acteurs) { acteur ->
            Column {
                ElevatedCard(elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                    modifier = Modifier
                        .size(width = 200.dp, height = 375.dp)
                        .padding(8.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color(0xFFD2B48C)
                    )) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w780/" + acteur.profile_path,
                        contentDescription = "films"
                    )
                    Text(
                        text = acteur.original_name,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }

}
