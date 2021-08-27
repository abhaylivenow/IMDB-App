package com.eazyalgo.imdbapp.data.repository.tvshow.dataSource

import com.eazyalgo.imdbapp.data.model.Artist.ArtistList
import com.eazyalgo.imdbapp.data.model.TvShow.TvShowList
import com.eazyalgo.imdbapp.data.model.movie.Movie
import com.eazyalgo.imdbapp.data.model.movie.MovieList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShow(): Response<TvShowList>
}