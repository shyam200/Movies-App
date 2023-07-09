package com.example.moviesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movies")
data class MovieModel(
    @PrimaryKey
    @SerializedName("id")
    val id :Int,
    @SerializedName("title")
    val title : String,
    @SerializedName("overview")
    val overview : String,
    @SerializedName("poster_path")
    val poster_path : String,
    @SerializedName("release_date")
    val releaseDate : String
)
