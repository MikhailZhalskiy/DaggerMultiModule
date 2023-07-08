package com.mw.example.repositories_api

import com.mw.example.data_model.Person

interface PersonRepository {
    fun getList(): List<Person>
    fun getPerson(): Person
}