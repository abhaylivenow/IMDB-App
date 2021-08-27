package com.eazyalgo.imdbapp.data.repository.movie.dataSource

import com.eazyalgo.imdbapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}