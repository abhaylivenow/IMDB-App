package com.eazyalgo.imdbapp.data.repository.artist

import android.util.Log
import com.eazyalgo.imdbapp.data.model.Artist.Artist
import com.eazyalgo.imdbapp.data.model.movie.Movie
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistCacheDataSource
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistLocalDataSource
import com.eazyalgo.imdbapp.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.eazyalgo.imdbapp.data.repository.artist.dataSourceImpl.ArtistCacheDataSourceImpl
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.eazyalgo.imdbapp.domain.repository.ArtistRepository
import com.eazyalgo.imdbapp.domain.repository.MovieRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        /**
         * first check if data is in cache, if yes then return it.
         * then it will check it cache is empty then it will get data from DB and show it
         * if db is empty then it will get data from API
         */
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtist)
        artistCacheDataSource.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromAPI(): List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body != null){
                artistList = body.artists
            }
        }catch (e: Exception){
            Log.i("Tag",e.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDb(): List<Artist>{
        lateinit var artistList: List<Artist>

        try{
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch (e : Exception){
            Log.i("Tag",e.message.toString())
        }

        // if movie data is already in table, then return movieList
        if(artistList.size > 0){
            return artistList
        }else{
            // list is empty so get data from remote and save to database
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>

        try{
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (e : Exception){
            Log.i("Tag",e.message.toString())
        }

        // if movie data is already in table, then return movieList
        if(artistList.size > 0){
            return artistList
        }else{
            // list is empty so get data from database and save to cache
            artistList = getArtistsFromDb()
            artistCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }
}