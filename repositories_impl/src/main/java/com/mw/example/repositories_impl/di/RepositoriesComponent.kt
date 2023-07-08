package com.mw.example.repositories_impl.di

import com.mw.example.repositories_api.di.RepositoriesApi
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [RepositoriesModule::class],
    dependencies = [RepositoriesDependencies::class]
)
@Singleton
internal abstract class RepositoriesComponent : RepositoriesApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: RepositoriesDependencies): RepositoriesComponent
    }

    companion object {
        private var component: RepositoriesComponent? = null

        fun initAndGet(dependencies: RepositoriesDependencies): RepositoriesComponent {
            if(component == null) {
                synchronized(RepositoriesComponent::class.java) {
                    if (component == null) {
                        component = DaggerRepositoriesComponent.factory().create(dependencies)
                    }
                }
            }
            return component ?: throw NullPointerException("$this")
        }
    }
}
