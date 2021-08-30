package com.eazyalgo.imdbapp.presentation.di.core

import com.eazyalgo.imdbapp.data.db.ArtistDao
import com.eazyalgo.imdbapp.data.db.MovieDao
import com.eazyalgo.imdbapp.data.db.TvShowDao
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistLocalDataSource
import com.eazyalgo.imdbapp.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowLocalDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalMovieDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideLocalTvShowDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideLocalArtistDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}