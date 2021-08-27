package com.eazyalgo.imdbapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eazyalgo.imdbapp.domain.usecase.GetMovieUseCase
import com.eazyalgo.imdbapp.domain.usecase.UpdateMovieCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieCase: UpdateMovieCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase,updateMovieCase) as T
    }

}