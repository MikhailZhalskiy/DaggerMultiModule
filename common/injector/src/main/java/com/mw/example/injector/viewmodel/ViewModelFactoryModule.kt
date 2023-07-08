package com.mw.example.injector.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Переиспользуемый модуль для инициализации [DaggerViewModelFactory]
 * Должен использоваться во всех компонентах, где есть View Model
 */

@Module
interface ViewModelFactoryModule {
    @Binds
//    @PerFeature
    fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}