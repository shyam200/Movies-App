package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.models.MovieListModel
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMoviesList() : Response<MovieListModel>
}