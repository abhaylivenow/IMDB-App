package com.eazyalgo.imdbapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.eazyalgo.imdbapp.data.model.movie.Movie

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // replace the old data with new data
    suspend fun saveTvShow(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tvShow")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_tvShow")
    suspend fun getTvShow(): List<TvShow>
}