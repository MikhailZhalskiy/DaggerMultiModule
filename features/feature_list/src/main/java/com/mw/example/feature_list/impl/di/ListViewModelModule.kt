package com.mw.example.feature_list.impl.di

import androidx.lifecycle.ViewModel
import com.mw.example.feature_list.impl.ListViewModel
import com.mw.example.injector.viewmodel.ViewModelFactoryModule
import com.mw.example.injector.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface ListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun bindsListViewModel(listViewModel: ListViewModel): ViewModel

}