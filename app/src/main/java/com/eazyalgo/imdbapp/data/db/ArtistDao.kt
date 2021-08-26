package com.eazyalgo.imdbapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eazyalgo.imdbapp.data.model.Artist.Artist
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.eazyalgo.imdbapp.data.model.movie.Movie

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // replace the old data with new data
    suspend fun saveArtist(artists: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtists(): List<Artist>
}