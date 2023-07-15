package com.example.moviesapp.presentation.di

import com.example.moviesapp.domain.usecases.GetMovieUsecase
import com.example.moviesapp.domain.usecases.UpdateMovieUsecase
import com.example.moviesapp.presentation.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieViewModuleFactory(getMovieUsecase: GetMovieUsecase, updateMovieUsecase: UpdateMovieUsecase): MoviesViewModelFactory{
        return MoviesViewModelFactory(getMovieUsecase, updateMovieUsecase)
    }
}