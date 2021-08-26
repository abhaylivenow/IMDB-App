package com.eazyalgo.imdbapp.data.model.movie


import com.eazyalgo.imdbapp.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>
)