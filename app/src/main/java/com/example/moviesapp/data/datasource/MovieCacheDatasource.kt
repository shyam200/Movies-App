package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.models.MovieModel

interface MovieCacheDatasource {
   suspend fun getMoviesFromCache() : List<MovieModel>
   suspend fun saveMoviesToCache(movies : List<MovieModel>)
}