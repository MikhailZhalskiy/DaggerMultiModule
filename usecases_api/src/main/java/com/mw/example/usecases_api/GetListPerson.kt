package com.mw.example.usecases_api

import com.mw.example.data_model.Person

interface GetListPerson {
    operator fun invoke(): List<Person>
}