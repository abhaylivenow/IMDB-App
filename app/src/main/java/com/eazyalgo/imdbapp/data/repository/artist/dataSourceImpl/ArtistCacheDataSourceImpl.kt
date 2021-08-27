package com.eazyalgo.imdbapp.data.repository.artist.dataSourceImpl

import com.eazyalgo.imdbapp.data.model.Artist.Artist
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}