package com.mw.example.usecases_impl

import com.mw.example.data_model.Person
import com.mw.example.repositories_api.PersonRepository
import com.mw.example.usecases_api.GetPerson
import javax.inject.Inject

class GetPersonImpl @Inject constructor(
    private val personRepository: PersonRepository
): GetPerson {

    override fun invoke(): Person = personRepository.getPerson()
}