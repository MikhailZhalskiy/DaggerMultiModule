package com.mw.example.usecases_impl

import com.mw.example.data_model.Person
import com.mw.example.repositories_api.PersonRepository
import com.mw.example.usecases_api.GetListPerson
import javax.inject.Inject

internal class GetListPersonImpl @Inject constructor(
    private val personRepository: PersonRepository
): GetListPerson {

    override fun invoke(): List<Person> {
        return personRepository.getList()
    }
}