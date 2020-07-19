package com.example.tmdbtask

import com.example.tmdbtask.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getmovies(
        @Query("api_key") apiKey:String
    ): Call<MovieResponse>

    @GET("movie/top_rated")
    fun getmovies2(
        @Query("api_key") apiKey:String
    ): Call<MovieResponse>
}