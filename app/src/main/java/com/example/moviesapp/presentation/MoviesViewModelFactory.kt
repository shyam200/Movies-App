package com.example.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.domain.usecases.GetMovieUsecase
import com.example.moviesapp.domain.usecases.UpdateMovieUsecase

class MoviesViewModelFactory(
    private val getMovieUsecase: GetMovieUsecase,
    private val updateMovieUsecase: UpdateMovieUsecase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesVIewModel(getMovieUsecase, updateMovieUsecase) as T
    }
}