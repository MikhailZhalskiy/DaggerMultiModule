package com.mw.example.usecases_impl.di

import com.mw.example.usecases_api.GetListPerson
import com.mw.example.usecases_api.GetPerson
import com.mw.example.usecases_impl.GetListPersonImpl
import com.mw.example.usecases_impl.GetPersonImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface UseCaseModule {

    @Singleton
    @Binds
    fun bindsGetListPerson(getListPerson: GetListPersonImpl): GetListPerson

    @Singleton
    @Binds
    fun bindGetPerson(getPerson: GetPersonImpl): GetPerson
}
