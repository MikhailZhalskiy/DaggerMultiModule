package com.mw.example.usecases_api.di

import com.mw.example.injector.BaseApi
import com.mw.example.usecases_api.GetListPerson
import com.mw.example.usecases_api.GetPerson

interface UseCaseApi: BaseApi {
    val getListPerson: GetListPerson
    val getPerson: GetPerson
}