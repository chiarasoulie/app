package com.example.firstapplicationchiara

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Composable qui affiche les détails d'une série, y compris l'affiche, le titre, la description,
 * les genres, la note, la date de sortie, le nombre d'épisodes et de saisons et les acteurs associés.
 *
 * Paramètres :
 * @param viewModel - Le ViewModel qui contient la logique métier et les données associées au film.
 * @param id - L'identifiant unique du film dont les détails doivent être affichés.
 */
@Composable
fun SerieDetailFun(viewModel: MainViewModel, id: String) {
    val serieDetail by viewModel.serieDetails.collectAsState()


    viewModel.getSerieDetail(id)


    serieDetail?.let {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3 colonnes dans la grille
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            // Premier élément, qui prend 3 colonnes
            item(span = { GridItemSpan(3) }) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(), // Prend toute la largeur
                    horizontalAlignment = Alignment.CenterHorizontally // Centre les éléments horizontalement
                ) {
                    // Affiche du film
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w780/" + it.poster_path,
                        contentDescription = "Affiche du film",
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                    )

                    // Titre du film
                    Text(
                        text = it.original_name,
                        textAlign = TextAlign.Center,
                        style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                    )

                    // Description du film
                    Text(
                        text = it.overview,
                        textAlign = TextAlign.Justify,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(horizontal = 18.dp)
                            .padding(bottom = 16.dp)
                    )

                    // Section informations
                    Text(
                        text = "Informations",
                        style = androidx.compose.material3.MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                }
            }
            // Genre de la serie (à prendre les 3 colonnes)
            item(span = { GridItemSpan(3) }) {
                Text(
                    text = "Genre : " + it.genres.joinToString(", ") { genre -> genre.name },
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth(), // Prend toute la largeur

                )
            }

            // Informations supplémentaires (Note et Date de sortie)
            item(span = { GridItemSpan(3) }) {
                Column {
                    // Note
                    Text(
                        text = "Note : " + it.vote_average.toString(),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // Date de sortie
                    Text(
                        text = "Sortie le " + it.first_air_date,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    )

                    // Nombre d'épisodes
                    Text(
                        text = "Nombres d'episodes : " + it.number_of_episodes,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    )

                    // Nombre de saisons
                    Text(
                        text = "Nombres de saisons : " + it.number_of_seasons,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    )
                }
            }

            item(span = { GridItemSpan(3) }) {
                // Titre des acteurs
                Text(
                    text = "Cast",
                    style = androidx.compose.material3.MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                        .fillMaxWidth(), // Prend toute la largeur
                    textAlign = TextAlign.Center // Centré horizontalement
                )
            }


            // Liste des acteurs
            items(it.credits.cast) { acteur ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Photo de l'acteur
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500/" + acteur.profile_path,
                        contentDescription = acteur.name,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                    )
                    // Nom de l'acteur
                    Text(
                        text = acteur.name,
                        textAlign = TextAlign.Center,
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}