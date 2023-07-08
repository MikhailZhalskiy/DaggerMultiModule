package com.mw.example.ds_remote_api

import com.mw.example.data_model.Person

interface RemoteService{
    fun getList(): List<Person>
    fun getPerson(): Person
}