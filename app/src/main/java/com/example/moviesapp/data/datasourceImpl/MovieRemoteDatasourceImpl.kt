package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.datasource.MovieRemoteDatasource
import com.example.moviesapp.data.models.MovieListModel
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDatasource {
    override suspend fun getMoviesList(): Response<MovieListModel> =
        tmdbService.getMoviesList(apiKey)

}