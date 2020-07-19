package com.example.tmdbtask.models

data class Movie(
    var poster_path:String,
    var title:String,
    var overview:String,
    var release_date:String,
    val vote_average: String,
    var backdrop_path:String) {
}