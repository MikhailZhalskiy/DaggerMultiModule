package com.mw.example.usecases_impl.di

import com.mw.example.injector.BaseDependencies
import com.mw.example.repositories_api.PersonRepository

interface UseCaseDependencies: BaseDependencies {
    val personRepository: PersonRepository
}
