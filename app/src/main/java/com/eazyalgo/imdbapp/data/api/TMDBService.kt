package com.eazyalgo.imdbapp.data.api

import com.eazyalgo.imdbapp.data.model.movie.MovieList
import com.eazyalgo.imdbapp.data.model.Artist.ArtistList
import com.eazyalgo.imdbapp.data.model.TvShow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularPerson(@Query("api_key") apiKey: String): Response<ArtistList>
}