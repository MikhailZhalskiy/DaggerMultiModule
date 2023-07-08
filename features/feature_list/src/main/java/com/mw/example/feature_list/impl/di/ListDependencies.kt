package com.mw.example.feature_list.impl.di

import com.mw.example.injector.BaseDependencies
import com.mw.example.usecases_api.GetListPerson

interface ListDependencies : BaseDependencies {
    val getListPerson: GetListPerson
}
