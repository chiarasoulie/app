package com.example.firstapplicationchiara

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowSizeClass
import coil.compose.AsyncImage

@Composable
fun DescPlaylist(navController: NavHostController, viewmodel: MainViewModel, windowSizeClass: WindowSizeClass){
    val playlist by viewmodel.playlist.collectAsState()
    viewmodel.getPlaylist()

    playlist?.let {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3 colonnes dans la grille
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ){
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
        }
    }



    }