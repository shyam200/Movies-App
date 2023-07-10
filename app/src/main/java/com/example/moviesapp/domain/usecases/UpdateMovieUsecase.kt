package com.example.moviesapp.domain.usecases

import com.example.moviesapp.data.models.MovieModel
import com.example.moviesapp.domain.repository.MoviesRepository

class UpdateMovieUsecase(private val repository: MoviesRepository) {
    suspend fun execute() : List<MovieModel>? = repository.updateMovies()
}