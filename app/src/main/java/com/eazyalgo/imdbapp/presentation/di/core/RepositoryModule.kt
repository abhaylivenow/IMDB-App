package com.eazyalgo.imdbapp.presentation.di.core

import com.eazyalgo.imdbapp.data.repository.artist.ArtistRepositoryImpl
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistCacheDataSource
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistLocalDataSource
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.eazyalgo.imdbapp.data.repository.movie.MovieRepositoryImpl
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.TvShowRepositoryImpl
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowCacheDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowLocalDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowRemoteDataSource
import com.eazyalgo.imdbapp.domain.repository.ArtistRepository
import com.eazyalgo.imdbapp.domain.repository.MovieRepository
import com.eazyalgo.imdbapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{

        return MovieRepositoryImpl(
            movieCacheDataSource,movieRemoteDataSource,movieLocalDataSource
        )

    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowCacheDataSource,tvShowRemoteDataSource,tvShowLocalDataSource
        )

    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistCacheDataSource,artistRemoteDataSource,artistLocalDataSource
        )

    }
}