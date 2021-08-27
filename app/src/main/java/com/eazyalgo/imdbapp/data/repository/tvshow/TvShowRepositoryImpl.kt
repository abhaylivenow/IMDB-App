package com.eazyalgo.imdbapp.data.repository.tvshow

import android.util.Log
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.eazyalgo.imdbapp.data.model.movie.Movie
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowCacheDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowLocalDataSource
import com.eazyalgo.imdbapp.data.repository.tvshow.dataSource.TvShowRemoteDataSource
import com.eazyalgo.imdbapp.domain.repository.MovieRepository
import com.eazyalgo.imdbapp.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        /**
         * first check if data is in cache, if yes then return it.
         * then it will check it cache is empty then it will get data from DB and show it
         * if db is empty then it will get data from API
         */
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowFromAPI(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if(body != null){
                tvShowList = body.tvShows
            }
        }catch (e: Exception){
            Log.i("Tag",e.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowFromDb(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try{
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        }catch (e : Exception){
            Log.i("Tag",e.message.toString())
        }

        // if movie data is already in table, then return movieList
        if(tvShowList.size > 0){
            return tvShowList
        }else{
            // list is empty so get data from remote and save to database
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try{
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (e : Exception){
            Log.i("Tag",e.message.toString())
        }

        // if movie data is already in table, then return movieList
        if(tvShowList.size > 0){
            return tvShowList
        }else{
            // list is empty so get data from database and save to cache
            tvShowList = getTvShowFromDb()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }

        return tvShowList
    }
}