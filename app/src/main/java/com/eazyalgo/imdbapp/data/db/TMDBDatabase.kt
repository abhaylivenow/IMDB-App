package com.eazyalgo.imdbapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eazyalgo.imdbapp.data.model.Artist.Artist
import com.eazyalgo.imdbapp.data.model.TvShow.TvShow
import com.eazyalgo.imdbapp.data.model.movie.Movie

@Database(entities = [Movie::class,TvShow::class,Artist::class],version = 1,exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}