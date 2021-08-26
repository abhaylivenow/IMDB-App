package com.eazyalgo.imdbapp.domain.repository

import com.eazyalgo.imdbapp.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}