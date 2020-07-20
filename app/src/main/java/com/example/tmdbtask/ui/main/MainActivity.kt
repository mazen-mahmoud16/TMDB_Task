package com.example.tmdbtask.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBar
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.example.tmdbtask.R
import com.example.tmdbtask.models.Movie
import com.example.tmdbtask.repositories.MoviesRepositories
import com.example.tmdbtask.repositories.MoviesRepositories.getMovies
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Observer

class MainActivity : AppCompatActivity() {

    val context: Context = this
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val actionBar: ActionBar = supportActionBar!!
        actionBar.title = "Movies"

        popular.setOnClickListener() {
            mainViewModel.getMovies().observe(this, androidx.lifecycle.Observer {
                main_recycler.adapter = MoviesAdapter(this, it)
            })
        }

        topRated.setOnClickListener() {
            mainViewModel.getMovies2().observe(this, androidx.lifecycle.Observer {
                main_recycler.adapter = MoviesAdapter(this, it)
            })
        }
    }
}
