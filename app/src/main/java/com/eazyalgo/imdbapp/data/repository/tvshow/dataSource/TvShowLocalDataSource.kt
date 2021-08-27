package com.eazyalgo.imdbapp.data.repository.tvshow.dataSource

import com.eazyalgo.imdbapp.data.model.Artist.Artist
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.eazyalgo.imdbapp.data.model.movie.Movie

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}