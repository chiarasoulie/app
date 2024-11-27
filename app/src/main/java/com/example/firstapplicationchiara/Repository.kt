package com.example.firstapplicationchiara

import javax.inject.Inject

class Repository @Inject constructor(private val tmdbapi : TmbdAPI) {

    val apikey = "9c9a8bdde556b573366003461f695329"

    suspend fun lastMovies() = tmdbapi.movieList(apikey).results
}