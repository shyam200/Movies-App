package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.models.MovieModel

interface MoviesRepository {
    suspend fun getMovies() : List<MovieModel>?
    suspend fun updateMovies() :List<MovieModel>?
}