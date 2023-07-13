package com.example.moviesapp.data.repositoryImpl

import android.graphics.Movie
import android.widget.Toast
import com.example.moviesapp.data.datasource.MovieCacheDatasource
import com.example.moviesapp.data.datasource.MovieLocalDatasource
import com.example.moviesapp.data.datasource.MovieRemoteDatasource
import com.example.moviesapp.data.models.MovieModel
import com.example.moviesapp.domain.repository.MoviesRepository

///This class will hold the implementation for the movies repository and serves the purpose of [connecting the data and domain] layer
// * The flow to get the data is defined as first get the data from cache if not present then fetch it from room database and if not present there as well then fetch it from Remote(Server)
class MoviesRepositoryImpl(
    private val remoteDatasource: MovieRemoteDatasource,
    private val localDatasource: MovieLocalDatasource,
    private val cacheDatasource: MovieCacheDatasource
) : MoviesRepository {
    override suspend fun getMovies(): List<MovieModel>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<MovieModel>? {
        //Refreshing the data from server
        val newMoviesList = getMoviesFromAPI()
        //clear all data and saving fresh data
        localDatasource.clearAll()
        localDatasource.saveMoviesToDB(newMoviesList)
        cacheDatasource.saveMoviesToCache(newMoviesList)
        return newMoviesList
    }

    private suspend fun getMoviesFromAPI(): List<MovieModel> {
        lateinit var movieList: List<MovieModel>
        try {
            val response = remoteDatasource.getMoviesList()
            val body = response.body()
            if (body != null) {
                movieList = body.results
            }
        } catch (exception: Exception) {
            println("Unable to fetch data from API")
        }
        return movieList
    }

    private suspend fun getMoviesFromDatabase(): List<MovieModel> {
        lateinit var movieList: List<MovieModel>
        try {
            var movies = localDatasource.getMovieFromDB()
            if (movies.isNotEmpty()) {
                movieList = movies
            } else {
                movieList = getMoviesFromAPI()
                localDatasource.saveMoviesToDB(movieList)
            }
        } catch (exception: Exception) {
            println("Unable to fetch the data from data base")
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<MovieModel>? {
        lateinit var moviesList: List<MovieModel>

        try {
            //first fetch from cache
            val movies = cacheDatasource.getMoviesFromCache()
            if (movies.isNotEmpty()) {
                moviesList = movies
            } else {
                moviesList = getMoviesFromDatabase()
                cacheDatasource.saveMoviesToCache(moviesList)
            }
        } catch (exception: Exception) {
            println("Unable to fetch the data from cache")
        }

        return moviesList
    }
}