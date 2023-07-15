package com.example.moviesapp.presentation.di

interface Injector {

    fun createMovieSubComponent() : MovieSubComponent
}