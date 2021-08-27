package com.eazyalgo.imdbapp.data.repository.artist.dataSource

import com.eazyalgo.imdbapp.data.model.Artist.Artist
import com.eazyalgo.imdbapp.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}