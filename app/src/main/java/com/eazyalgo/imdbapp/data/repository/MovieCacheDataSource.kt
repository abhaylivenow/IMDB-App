package com.eazyalgo.imdbapp.data.repository

import com.eazyalgo.imdbapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}