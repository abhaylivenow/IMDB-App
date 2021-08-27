package com.eazyalgo.imdbapp.data.repository.movie

import android.util.Log
import com.eazyalgo.imdbapp.data.model.movie.Movie
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.eazyalgo.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.eazyalgo.imdbapp.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        /**
         * first check if data is in cache, if yes then return it.
         * then it will check it cache is empty then it will get data from DB and show it
         * if db is empty then it will get data from API
         */
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDb(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch (e: Exception){
            Log.i("Tag",e.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDb(): List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (e : Exception){
            Log.i("Tag",e.message.toString())
        }

        // if movie data is already in table, then return movieList
        if(movieList.size > 0){
            return movieList
        }else{
            // list is empty so get data from remote and save to database
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDb(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e : Exception){
            Log.i("Tag",e.message.toString())
        }

        // if movie data is already in table, then return movieList
        if(movieList.size > 0){
            return movieList
        }else{
            // list is empty so get data from database and save to cache
            movieList = getMoviesFromDb()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}