package com.eazyalgo.imdbapp.data.repository.artist.dataSource

import com.eazyalgo.imdbapp.data.model.Artist.ArtistList
import com.eazyalgo.imdbapp.data.model.movie.Movie
import com.eazyalgo.imdbapp.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}