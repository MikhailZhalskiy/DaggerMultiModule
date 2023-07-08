package com.mw.example.feature_detail.impl.di

import com.mw.example.injector.BaseDependencies
import com.mw.example.usecases_api.GetPerson

interface DetailDependencies: BaseDependencies {
    val getPerson: GetPerson
}
