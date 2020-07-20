package com.example.tmdbtask.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tmdbtask.models.Movie
import com.example.tmdbtask.repositories.MoviesRepositories

class MainViewModel : ViewModel() {
    fun getMovies(): LiveData<List<Movie>> {
        return MoviesRepositories.getMovies()
    }
    fun getMovies2(): LiveData<List<Movie>> {
        return MoviesRepositories.getMovies2()
    }
}