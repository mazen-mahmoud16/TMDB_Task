package com.example.tmdbtask.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBar
import android.os.Bundle
import com.example.tmdbtask.R
import com.example.tmdbtask.models.Movie
import com.example.tmdbtask.repositories.MoviesRepositories
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MoviesRepositories.MoviesCallback{

    //private lateinit var apiService: ApiService
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val actionBar: ActionBar = supportActionBar!!
        actionBar.title="Movies"

        /*apiService = RetrofitClient.getClient().create(ApiService::class.java)


        apiService.getmovies("afbb384baea489e5ae822b9a67778a98")
            .enqueue(object : Callback<MovieResponse> {

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    val moviesList: List<Movie> = response.body()?.results ?: listOf()
                    main_recycler.adapter = MoviesAdapter(context, moviesList)
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e("Error ", t.message.toString())
                }


            })

        popular.setOnClickListener() {
            apiService.getmovies("afbb384baea489e5ae822b9a67778a98")
                .enqueue(object : Callback<MovieResponse> {

                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        val moviesList: List<Movie> = response.body()?.results ?: listOf()
                        main_recycler.adapter = MoviesAdapter(context, moviesList)
                    }

                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.e("Error ", t.message.toString())
                    }


                })

        }
        topRated.setOnClickListener() {
            apiService.getmovies2("afbb384baea489e5ae822b9a67778a98")
                .enqueue(object : Callback<MovieResponse> {

                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        val moviesList: List<Movie> = response.body()?.results ?: listOf()
                        main_recycler.adapter = MoviesAdapter(context, moviesList)
                    }

                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.e("Error ", t.message.toString())
                    }


                })

        }*/
        popular.setOnClickListener() {
            MoviesRepositories.getmovies(this)
        }
        topRated.setOnClickListener() {
            MoviesRepositories.getmovies2(this)
        }
    }

    override fun onMoviesReady(movies: List<Movie>) {
            main_recycler.adapter =
                MoviesAdapter(context, movies)
        }
    }
