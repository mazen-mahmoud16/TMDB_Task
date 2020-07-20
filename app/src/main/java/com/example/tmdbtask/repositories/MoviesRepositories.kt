package com.example.tmdbtask.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private var moviesList2: MutableList<Movie> = mutableListOf()

    public var  i:Int = 0;


    fun getMovies(): LiveData<List<Movie>> {

        val moviesListLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

        i=2

        if (moviesList.size > 0) {
            moviesListLiveData.postValue(moviesList)
            return moviesListLiveData
        }

        apiService.getmovies(apiKey).enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                if (response.isSuccessful) {
                    val remoteMoviesList: List<Movie> = response.body()?.results ?: listOf()
                    moviesList.addAll(remoteMoviesList)
                    moviesListLiveData.postValue(moviesList)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("tag", t.message.toString())
            }

        })
        return moviesListLiveData
    }

    fun getMovies2(): LiveData<List<Movie>> {

        val moviesListLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

        i=3


        if (moviesList2.size > 0) {
            moviesListLiveData.postValue(moviesList2)
            return moviesListLiveData
        }

        apiService.getmovies2(apiKey).enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                if (response.isSuccessful) {
                    val remoteMoviesList: List<Movie> = response.body()?.results ?: listOf()
                    moviesList2.addAll(remoteMoviesList)
                    moviesListLiveData.postValue(moviesList2)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("tag", t.message.toString())
            }

        })
        return moviesListLiveData
    }

}
