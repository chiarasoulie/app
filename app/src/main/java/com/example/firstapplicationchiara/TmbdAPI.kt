package com.example.firstapplicationchiara

import TmdbResult2
import TmdbResult3
import TmdbResult4
import TmdbResult5
import TmdbResults
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TmbdAPI {
    @GET("trending/movie/week")
    suspend fun movieList(@Query("api_key") apikey: String) : TmdbResults

    @GET("search/movie")
    suspend fun getFilmsByKeyWord(
        @Query("api_key") apiKey: String,
        @Query("query") keyWord: String) : TmdbResults

    @GET("trending/tv/week")
    suspend fun serieList(@Query("api_key") apikey: String) : TmdbResult2

    @GET("search/tv")
    suspend fun getSeriesByKeyWord(
        @Query("api_key") apiKey: String,
        @Query("query") keyWord: String) : TmdbResult2

    @GET("trending/person/week")
    suspend fun actorsList(@Query("api_key") apikey: String) : TmdbResult3

    @GET("search/person")
    suspend fun getPersonByKeyWord(
        @Query("api_key") apiKey: String,
        @Query("query") keyWord: String) : TmdbResult3

    @GET("movie/{movie_id}?append_to_response=credits")
    suspend fun getFilmDetail(
        @Path("movie_id") movieId:String,
        @Query("api_key") apikey: String) : TmdbResult4

    @GET("tv/{tv_id}?append_to_response=credits")
    suspend fun getSerieDetail(
        @Path("tv_id") tvId:String,
        @Query("api_key") apikey: String) : TmdbResult5

}