package com.mw.example.daggermultimodule.di

import com.mw.example.ds_remote_api.RemoteService
import com.mw.example.ds_remote_api.di.RemoteApi
import com.mw.example.ds_remote_impl.di.RemoteComponentHolder
import com.mw.example.ds_remote_impl.di.RemoteDependencies
import com.mw.example.feature_detail.api.di.DetailApi
import com.mw.example.feature_detail.impl.di.DetailComponentHolder
import com.mw.example.feature_detail.impl.di.DetailDependencies
import com.mw.example.feature_list.api.di.ListApi
import com.mw.example.feature_list.impl.di.ListComponentHolder
import com.mw.example.feature_list.impl.di.ListDependencies
import com.mw.example.injector.BaseDependencies
import com.mw.example.injector.ComponentDependenciesKey
import com.mw.example.repositories_api.PersonRepository
import com.mw.example.repositories_api.di.RepositoriesApi
import com.mw.example.repositories_impl.di.RepositoriesComponentHolder
import com.mw.example.repositories_impl.di.RepositoriesDependencies
import com.mw.example.usecases_api.GetListPerson
import com.mw.example.usecases_api.GetPerson
import com.mw.example.usecases_api.di.UseCaseApi
import com.mw.example.usecases_impl.di.UseCaseComponentHolder
import com.mw.example.usecases_impl.di.UseCaseDependencies
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesRemoteDependencies(): RemoteDependencies =
        object : RemoteDependencies {}

    @Provides
    fun providesRemoteApi(dependencies: RemoteDependencies): RemoteApi {
        RemoteComponentHolder.init(dependencies)
        return RemoteComponentHolder.get()
    }

    @Singleton
    @Provides
    fun providesRepositoriesDependencies(remoteApi: RemoteApi): RepositoriesDependencies =
        object : RepositoriesDependencies {
            override val remoteService: RemoteService
                get() = remoteApi.getRemoteService()
        }

    @Provides
    fun providesRepositoriesApi(dependencies: RepositoriesDependencies): RepositoriesApi {
        RepositoriesComponentHolder.init(dependencies)
        return RepositoriesComponentHolder.get()
    }

    @Singleton
    @Provides
    fun providesUseCaseDependencies(repositoriesApi: RepositoriesApi): UseCaseDependencies =
        object : UseCaseDependencies {
            override val personRepository: PersonRepository
                get() = repositoriesApi.personRepository
        }

    @Provides
    fun providesUseCaseApi(dependencies: UseCaseDependencies): UseCaseApi {
        UseCaseComponentHolder.init(dependencies)
        return UseCaseComponentHolder.get()
    }

    @Singleton
    @Provides
    fun providesListDependencies(useCaseApi: UseCaseApi): ListDependencies =
        object : ListDependencies {
            override val getListPerson: GetListPerson
                get() = useCaseApi.getListPerson
        }

    @Provides
    fun providesListApi(dependencies: ListDependencies): ListApi {
        ListComponentHolder.init(dependencies)
        return ListComponentHolder.get()
    }

    @Singleton
    @Provides
    fun providesDetailDependencies(useCaseApi: UseCaseApi): DetailDependencies =
        object : DetailDependencies {
            override val getPerson: GetPerson
                get() = useCaseApi.getPerson
        }

    @Provides
    fun providesDetailApi(dependencies: DetailDependencies): DetailApi {
        DetailComponentHolder.init(dependencies)
        return DetailComponentHolder.get()
    }
}

@Module
interface BaseDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(ListDependencies::class)
    fun bindsListDependencies(dependencies: ListDependencies): BaseDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(DetailDependencies::class)
    fun bindsDetailDependencies(dependencies: DetailDependencies): BaseDependencies
}