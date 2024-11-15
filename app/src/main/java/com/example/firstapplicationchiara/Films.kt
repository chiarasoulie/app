package com.example.firstapplicationchiara

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DescFilms(viewmodel: MainViewModel) {
    val movies by viewmodel.movies.collectAsState()
    if (movies.isEmpty()) viewmodel.getFilms()
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {

        items(movies) { movie ->
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
                        model = "https://image.tmdb.org/t/p/w780/" + movie.poster_path,
                        contentDescription = "films"
                    )
                    Text(
                        text = movie.original_title,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    // Date de sortie
                    Text(
                        text = movie.release_date,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }

}
