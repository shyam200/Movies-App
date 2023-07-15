package com.example.moviesapp.presentation.di

import com.example.moviesapp.presentation.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule :: class])
interface MovieSubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : MovieSubComponent
    }
}