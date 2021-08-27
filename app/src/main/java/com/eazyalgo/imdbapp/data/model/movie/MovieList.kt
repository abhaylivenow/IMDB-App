package com.eazyalgo.imdbapp.data.model.movie


import com.eazyalgo.imdbapp.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)