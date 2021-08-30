package com.eazyalgo.imdbapp.presentation.di.core

import com.eazyalgo.imdbapp.data.api.TMDBService
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.eazyalgo.imdbapp.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowRemoteDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }
}