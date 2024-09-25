package com.example.firstapplicationchiara

import Movie
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainViewModel : ViewModel(){
    val movies = MutableStateFlow<List<Movie>>(listOf())

    val apikey = "9c9a8bdde556b573366003461f695329"

    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmbdAPI::class.java)

    fun getFilms(){
        viewModelScope.launch {
            movies.value = service.movieList(apikey).results
        }
    }
}