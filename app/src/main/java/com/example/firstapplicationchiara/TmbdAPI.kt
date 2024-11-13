package com.example.firstapplicationchiara

import TmdbResults
import retrofit2.http.GET
import retrofit2.http.Query


interface TmbdAPI {
    @GET("trending/movie/week")
    suspend fun movieList(@Query("api_key") apikey: String) : TmdbResults

    @GET("search/movie")
    suspend fun getFilmsByKeyWord(
        @Query("api_key") apiKey: String,
        @Query("query") keyWord: String) : TmdbResults

   // @GET("search/tv")
   // suspend fun getSeriesByKeyWord(
   //     @Query("api_key") apiKey: String,
    //    @Query("query") keyWord: String) : TvShowResults
}