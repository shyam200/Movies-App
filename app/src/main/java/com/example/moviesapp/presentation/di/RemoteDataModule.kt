package com.example.moviesapp.presentation.di

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.datasource.MovieRemoteDatasource
import com.example.moviesapp.data.datasourceImpl.MovieRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun providesRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(tmdbService, apiKey)
    }
}