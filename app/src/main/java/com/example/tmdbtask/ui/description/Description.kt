package com.example.tmdbtask.ui.description

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*
import androidx.appcompat.app.ActionBar
import com.example.tmdbtask.R

class Description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)


        movieName.text= intent.getStringExtra("name")
        releaseDate.text = intent.getStringExtra("date")
        rate.text = intent.getStringExtra("vote")
        overviewText.text = intent.getStringExtra("overview")
        var poster: String? = intent.getStringExtra("poster")
        var background: String? = intent.getStringExtra("background")

        var actionBar: ActionBar = supportActionBar!!
        actionBar.title=intent.getStringExtra("name")
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${poster}").into(posterImage)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${background}").into(backdropImage)

    }
}