package com.example.firstapplicationchiara

import Actor
import Movie
import Serie
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainViewModel : ViewModel(){
    private val _movies = MutableStateFlow<List<Movie>>(listOf())
    val movies = _movies.asStateFlow()

    private val _series = MutableStateFlow<List<Serie>>(listOf())
    val series = _series.asStateFlow()

    private val _acteurs = MutableStateFlow<List<Actor>>(listOf())
    val acteurs = _acteurs.asStateFlow()

    val apikey = "9c9a8bdde556b573366003461f695329"

    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmbdAPI::class.java)

    fun getFilms(){
        viewModelScope.launch {
            _movies.value = service.movieList(apikey).results
        }
    }

    fun searchMovies(keyWord : String){
        viewModelScope.launch{
            _movies.value = service.getFilmsByKeyWord(apikey, keyWord).results
        }
    }

    fun getSeries(){
        viewModelScope.launch {
            _series.value = service.serieList(apikey).results
        }
    }

    fun searchSeries(keyWord : String){
        viewModelScope.launch{
            _series.value = service.getSeriesByKeyWord(apikey, keyWord).results
        }
    }
    fun getActeurs(){
        viewModelScope.launch {
            _acteurs.value = service.actorsList(apikey).results
        }
    }

    fun searchActeurs(keyWord : String){
        viewModelScope.launch{
            _acteurs.value = service.getPersonByKeyWord(apikey, keyWord).results
        }
    }
}