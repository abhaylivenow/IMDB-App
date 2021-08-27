package com.eazyalgo.imdbapp.data.repository.movie.dataSource

import com.eazyalgo.imdbapp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDb(movies: List<Movie>)
    suspend fun clearAll()
}