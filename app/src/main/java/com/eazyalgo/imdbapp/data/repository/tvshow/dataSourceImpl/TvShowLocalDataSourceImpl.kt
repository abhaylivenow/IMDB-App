package com.eazyalgo.imdbapp.data.repository.tvshow.dataSourceImpl

import com.eazyalgo.imdbapp.data.db.TvShowDao
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowsDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowFromDB(): List<TvShow> {
        return tvShowsDao.getTvShow()
    }

    override suspend fun saveTvShowToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteAllTvShow()
        }
    }
}