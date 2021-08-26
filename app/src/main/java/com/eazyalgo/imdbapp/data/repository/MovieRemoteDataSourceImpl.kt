package com.eazyalgo.imdbapp.data.repository

import com.eazyalgo.imdbapp.data.api.TMDBService
import com.eazyalgo.imdbapp.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}