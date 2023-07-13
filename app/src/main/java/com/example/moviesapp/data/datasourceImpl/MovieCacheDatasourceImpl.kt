package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.datasource.MovieCacheDatasource
import com.example.moviesapp.data.models.MovieModel

class MovieCacheDatasourceImpl : MovieCacheDatasource{
    private var moviesList = ArrayList<MovieModel>()

    override suspend fun getMoviesFromCache(): List<MovieModel> {
      return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<MovieModel>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}