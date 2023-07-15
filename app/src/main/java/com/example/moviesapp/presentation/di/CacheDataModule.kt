package com.example.moviesapp.presentation.di

import com.example.moviesapp.data.datasource.MovieCacheDatasource
import com.example.moviesapp.data.datasourceImpl.MovieCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesCacheDataSource() : MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }
}