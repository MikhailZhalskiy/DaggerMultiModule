package com.mw.example.usecases_api

import com.mw.example.data_model.Person

interface GetPerson {
    operator fun invoke(): Person
}