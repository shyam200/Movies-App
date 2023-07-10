package com.example.moviesapp.data.api

import com.example.moviesapp.data.models.MovieListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("/movie/popular")
    suspend fun getMoviesList(@Query("api_key") apiKey : String) : Response<MovieListModel>
}