package com.example.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.domain.usecases.GetMovieUsecase
import com.example.moviesapp.domain.usecases.UpdateMovieUsecase

class MoviesVIewModel(
    private val getMovieUsecase: GetMovieUsecase,
    private val updateMovieUsecase: UpdateMovieUsecase
) : ViewModel() {
    fun  getMovies() = liveData{
        val moviesList = getMovieUsecase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData{
        val moviesList = updateMovieUsecase.execute()
        emit(moviesList)
    }
}