package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.datasource.MovieLocalDatasource
import com.example.moviesapp.data.db.MoviesDao
import com.example.moviesapp.data.models.MovieModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val dao: MoviesDao) : MovieLocalDatasource {
    override suspend fun getMovieFromDB(): List<MovieModel> = dao.getAllMovies()

    override suspend fun saveMoviesToDB(movies: List<MovieModel>) {
        CoroutineScope(Dispatchers.IO).launch { dao.saveMovies(movies) }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllMovies()
        }
    }
}