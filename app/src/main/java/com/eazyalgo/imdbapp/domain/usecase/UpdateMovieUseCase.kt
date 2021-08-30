package com.eazyalgo.imdbapp.domain.usecase

import com.eazyalgo.imdbapp.data.model.movie.Movie
import com.eazyalgo.imdbapp.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}