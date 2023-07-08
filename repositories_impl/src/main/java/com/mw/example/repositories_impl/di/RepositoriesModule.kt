package com.mw.example.repositories_impl.di

import com.mw.example.repositories_api.PersonRepository
import com.mw.example.repositories_impl.PersonRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface RepositoriesModule {

    @Singleton
    @Binds
    fun bindsPersonRepositories(personRepository: PersonRepositoryImpl): PersonRepository
}