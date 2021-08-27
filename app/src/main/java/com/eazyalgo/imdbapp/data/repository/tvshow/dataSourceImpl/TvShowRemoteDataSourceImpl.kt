package com.eazyalgo.imdbapp.data.repository.tvshow.dataSourceImpl

import com.eazyalgo.imdbapp.data.api.TMDBService
import com.eazyalgo.imdbapp.data.model.TvShow.TvShowList
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}