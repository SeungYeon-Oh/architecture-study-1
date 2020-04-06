package com.example.ohsystudy

data class MovieList (val items : ArrayList<Movie>)

data class Movie(
    val title: String,
    val link: String,
    val image: String,
    val subtitle: String,
    val pubDate: String,
    val director: String,
    val actor: String,
    val usrRating: String
)