package com.example.tmdbtask.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbtask.ui.description.Description
import com.example.tmdbtask.R
import com.example.tmdbtask.models.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class MoviesAdapter(val context:Context,private val moviesList:List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        var movies =moviesList.get(position)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${movies.poster_path}").into(holder.image)
        holder.image.setOnClickListener(){
            val intent = Intent(context, Description::class.java)
            intent.putExtra("name",movies.title)
            intent.putExtra("date",movies.release_date)
            intent.putExtra("vote",movies.vote_average)
            intent.putExtra("overview",movies.overview)
            intent.putExtra("poster",movies.poster_path)
            intent.putExtra("background",movies.backdrop_path)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        public var image = itemView.movieImage
    }

}