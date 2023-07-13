package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.models.MovieModel

interface MovieLocalDatasource {
    suspend fun getMovieFromDB() : List<MovieModel>
    suspend fun saveMoviesToDB(movies : List<MovieModel>)
    suspend fun clearAll()
}