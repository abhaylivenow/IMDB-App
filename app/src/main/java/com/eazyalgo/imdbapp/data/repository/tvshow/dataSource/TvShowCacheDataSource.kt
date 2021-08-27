package com.eazyalgo.imdbapp.data.repository.tvshow.dataSource

import com.eazyalgo.imdbapp.data.model.Artist.Artist
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.eazyalgo.imdbapp.data.model.movie.Movie

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShows: List<TvShow>)
}