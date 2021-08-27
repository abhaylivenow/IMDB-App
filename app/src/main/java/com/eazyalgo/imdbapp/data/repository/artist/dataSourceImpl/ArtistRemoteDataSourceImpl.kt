package com.eazyalgo.imdbapp.data.repository.artist.dataSourceImpl

import com.eazyalgo.imdbapp.data.api.TMDBService
import com.eazyalgo.imdbapp.data.model.Artist.ArtistList
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }
}