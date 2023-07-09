package com.example.moviesapp.data

import com.google.gson.annotations.SerializedName

data class MovieListModel(
    @SerializedName("results")
    val results : List<MovieModel>
)
