package com.mw.example.ds_remote_impl

import com.mw.example.data_model.Person
import com.mw.example.ds_remote_api.RemoteService
import javax.inject.Inject

class RemoteServiceImpl @Inject constructor(): RemoteService {
    override fun getList(): List<Person> {
        return listOf(
            Person("First"),
            Person("Second")
        )
    }

    override fun getPerson(): Person {
        return Person("FirstPerson")
    }
}