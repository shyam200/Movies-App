package com.example.moviesapp.presentation.di

import com.example.moviesapp.data.datasource.MovieLocalDatasource
import com.example.moviesapp.data.datasourceImpl.MovieLocalDatasourceImpl
import com.example.moviesapp.data.db.MoviesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(dao: MoviesDao) : MovieLocalDatasource {
        return MovieLocalDatasourceImpl(dao)
    }
}