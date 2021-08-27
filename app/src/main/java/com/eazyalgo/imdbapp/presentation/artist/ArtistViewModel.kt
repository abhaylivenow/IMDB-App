package com.eazyalgo.imdbapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.eazyalgo.imdbapp.domain.usecase.GetArtistUseCase
import com.eazyalgo.imdbapp.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtist() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateTvShow() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }

}