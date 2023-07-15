package com.example.moviesapp.presentation.di

import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        DatabaseModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UsecaseModule::class,
    ]
)
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
}