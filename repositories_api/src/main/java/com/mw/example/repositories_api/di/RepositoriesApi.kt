package com.mw.example.repositories_api.di

import com.mw.example.injector.BaseApi
import com.mw.example.repositories_api.PersonRepository

interface RepositoriesApi: BaseApi {
    val personRepository: PersonRepository
}