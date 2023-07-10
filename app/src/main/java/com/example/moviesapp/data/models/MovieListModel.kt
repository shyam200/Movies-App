package com.example.moviesapp.data.models

import com.google.gson.annotations.SerializedName

data class MovieListModel(
    @SerializedName("results")
    val results : List<MovieModel>
)
