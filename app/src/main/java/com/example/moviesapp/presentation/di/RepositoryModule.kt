package com.example.moviesapp.presentation.di

import com.example.moviesapp.data.datasource.MovieCacheDatasource
import com.example.moviesapp.data.datasource.MovieLocalDatasource
import com.example.moviesapp.data.datasource.MovieRemoteDatasource
import com.example.moviesapp.data.repositoryImpl.MoviesRepositoryImpl
import com.example.moviesapp.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MoviesRepository {
        return MoviesRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }
}