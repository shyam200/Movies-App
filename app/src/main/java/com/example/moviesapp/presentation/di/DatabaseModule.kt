package com.example.moviesapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.db.MoviesDao
import com.example.moviesapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java, "tmdbClient"
        ).build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(tmdbDatabase: TMDBDatabase) : MoviesDao {
        return tmdbDatabase.moviesDao()
    }
}