package com.example.moviesapp.presentation.di

import com.example.moviesapp.domain.repository.MoviesRepository
import com.example.moviesapp.domain.usecases.GetMovieUsecase
import com.example.moviesapp.domain.usecases.UpdateMovieUsecase
import dagger.Module
import dagger.Provides

@Module
class UsecaseModule {

    @Provides
    fun providesGetMovieUsecase(movieRepository: MoviesRepository) : GetMovieUsecase{
        return GetMovieUsecase(movieRepository)
    }

    @Provides
    fun providesUpdateMovieUsecase(movieRepository: MoviesRepository) :UpdateMovieUsecase{
        return UpdateMovieUsecase(movieRepository)
    }
}