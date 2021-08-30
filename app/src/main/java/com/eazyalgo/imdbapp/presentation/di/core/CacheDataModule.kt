package com.eazyalgo.imdbapp.presentation.di.core

import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistCacheDataSource
import com.eazyalgo.imdbapp.data.repository.artist.dataSourceImpl.ArtistCacheDataSourceImpl
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowCacheDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}