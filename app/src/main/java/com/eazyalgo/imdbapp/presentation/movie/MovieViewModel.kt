package com.eazyalgo.imdbapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.eazyalgo.imdbapp.domain.usecase.GetMovieUseCase
import com.eazyalgo.imdbapp.domain.usecase.UpdateMovieCase

class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieCase: UpdateMovieCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieCase.execute()
        emit(movieList)
    }
}