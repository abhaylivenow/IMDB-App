package com.eazyalgo.imdbapp.domain.repository

import com.eazyalgo.imdbapp.data.model.Artist.Artist
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}