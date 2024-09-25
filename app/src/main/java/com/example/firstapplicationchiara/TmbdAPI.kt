package com.example.firstapplicationchiara

import TmdbResults
import retrofit2.http.GET
import retrofit2.http.Query


interface TmbdAPI {
    @GET("trending/movie/week")
    suspend fun movieList(@Query("api_key") apikey: String) : TmdbResults
}