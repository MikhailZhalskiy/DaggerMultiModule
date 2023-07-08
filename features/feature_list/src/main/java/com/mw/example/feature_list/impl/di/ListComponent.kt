package com.mw.example.feature_list.impl.di

import com.mw.example.feature_list.api.di.ListApi
import com.mw.example.feature_list.impl.ListFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [ListModule::class, ListViewModelModule::class],
    dependencies = [ListDependencies::class]
)
@Singleton
internal abstract class ListComponent: ListApi {

    abstract fun inject(fragment: ListFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: ListDependencies): ListComponent
    }

    companion object {
        private var component: ListComponent? = null

        fun initAndGet(dependencies: ListDependencies): ListComponent {
            if(component == null) {
                synchronized(ListComponent::class.java) {
                    if (component == null) {
                        component = DaggerListComponent.factory().create(dependencies)
                    }
                }
            }
            return component ?: throw NullPointerException("$this")
        }
    }
}