package com.example.firstapplicationchiara

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import coil.compose.AsyncImage

@Composable
fun DescFilms(viewmodel: MainViewModel) {
    val movies by viewmodel.movies.collectAsState()
    if (movies.isEmpty()) viewmodel.getFilms()
    Text(text = "hello")
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {

        items(movies) { movie ->
            Column {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w780/" + movie.poster_path,
                    contentDescription = "films"
                )
                Text(text = movie.original_title)
                Text(text = movie.release_date)
            }
        }
    }

}
