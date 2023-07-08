package com.mw.example.repositories_impl

import com.mw.example.data_model.Person
import com.mw.example.ds_remote_api.RemoteService
import com.mw.example.repositories_api.PersonRepository
import javax.inject.Inject

internal class PersonRepositoryImpl @Inject constructor(
    private val remoteService: RemoteService
): PersonRepository {

    override fun getList(): List<Person> {
        return remoteService.getList()
    }

    override fun getPerson(): Person {
        return remoteService.getPerson()
    }
}