package com.example.firstapplicationchiara

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import coil.compose.AsyncImage

@Composable
fun DescPlaylist(navController: NavHostController, viewmodel: MainViewModel, windowSizeClass: WindowSizeClass){
    val playlist by viewmodel.playlist.collectAsState()
    viewmodel.getPlaylist()
    var photo = 1;

    val columns = when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 2
        WindowWidthSizeClass.MEDIUM -> 4
        WindowWidthSizeClass.EXPANDED -> 4
        else -> 2
    }


    playlist?.let {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns), // 3 colonnes dans la grille
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            item(span = { GridItemSpan(columns) }) {
               Column(modifier = Modifier
                   .padding(16.dp)
                   .fillMaxWidth(), // Prend toute la largeur
                   horizontalAlignment = Alignment.CenterHorizontally) {

                   Row(
                       modifier = Modifier
                           .padding(16.dp)
                           .fillMaxWidth(), // Prend toute la largeur

                   ) {
                       // Affiche de la playlist
                       AsyncImage(
                           model = "file:///android_asset/images/cover.jpg",
                           contentDescription = "Affiche du film",
                           modifier = Modifier
                               .size(width = 150.dp, height = 175.dp)
                               .padding(8.dp),

                       )
                       // titre
                       Text(
                           text = it.title,
                           textAlign = TextAlign.Center,
                           style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,

                       )
                   }
                   Text(
                       text = "Créée par "+ it.creator.name+" "+ it.creator.type,
                       textAlign = TextAlign.Center,
                       modifier = Modifier
                           .padding(bottom = 16.dp)

                   )
               }

            }
            //Playlist
            items(it.tracks.data) { musique ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp),
                        modifier = Modifier
                            .size(width = 200.dp, height = 275.dp)
                            .padding(8.dp),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = Color(0xFFD2B48C)
                        )) {
                        // Photo de la musique
                        AsyncImage(
                            model = "file:///android_asset/images/"+photo+".jpg",
                            contentDescription = musique.title,
                            modifier = Modifier
                                .padding(bottom = 4.dp)
                        )
                        // Titre de la musique
                        Text(
                            text = musique.title,
                            textAlign = TextAlign.Center,
                            style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally)


                        )
                    }
                }
                photo = photo + 1;
            }
        }
    }



    }