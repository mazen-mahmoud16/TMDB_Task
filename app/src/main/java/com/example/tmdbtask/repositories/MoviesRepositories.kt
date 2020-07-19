package com.example.tmdbtask.repositories

import android.util.Log
import com.example.tmdbtask.models.Movie
import com.example.tmdbtask.models.MovieResponse
import com.example.tmdbtask.network.ApiService
import com.example.tmdbtask.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MoviesRepositories {

    private val apiService = RetrofitClient.getClient().create(ApiService::class.java)

    private const val apiKey = "afbb384baea489e5ae822b9a67778a98"

    private var moviesList: MutableList<Movie> = mutableListOf()

    fun getmovies(moviesCallback: MoviesCallback){

        /*if (moviesList.size > 0) {
            moviesCallback.onMoviesReady(moviesList)
            return
        }*/

        apiService.getmovies(apiKey).enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                if (response.isSuccessful) {
                    val remoteMoviesList: List<Movie> = response.body()?.results ?: listOf()
                    moviesList = mutableListOf()
                    moviesList.addAll(remoteMoviesList)
                    moviesCallback.onMoviesReady(moviesList)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("tag", t.message.toString())
            }

        })
    }

    fun getmovies2(moviesCallback: MoviesCallback){

        /*if (moviesList.size > 0) {
            moviesCallback.onMoviesReady(moviesList)
            return
        }*/

        apiService.getmovies2(apiKey).enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                if (response.isSuccessful) {
                    val remoteMoviesList: List<Movie> = response.body()?.results ?: listOf()
                    moviesList = mutableListOf()
                    moviesList.addAll(remoteMoviesList)
                    moviesCallback.onMoviesReady(moviesList)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("tag", t.message.toString())
            }

        })
    }

    //*******************************************************************************************
    interface MoviesCallback {
        fun onMoviesReady(movies: List<Movie>)
    }
}