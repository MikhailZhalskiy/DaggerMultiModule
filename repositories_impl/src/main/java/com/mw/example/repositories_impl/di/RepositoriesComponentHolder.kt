package com.mw.example.repositories_impl.di

import com.mw.example.injector.ComponentHolder
import com.mw.example.repositories_api.di.RepositoriesApi

object RepositoriesComponentHolder: ComponentHolder<RepositoriesApi, RepositoriesDependencies> {

    @Volatile
    private var repositoriesComponent: RepositoriesComponent? = null

    override fun init(dependencies: RepositoriesDependencies) {
        if (repositoriesComponent == null) {
            synchronized(RepositoriesComponentHolder::class.java) {
                if (repositoriesComponent == null) {
                    repositoriesComponent = RepositoriesComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): RepositoriesApi = getComponent()

    override fun reset() {
        repositoriesComponent = null
    }

    internal fun getComponent(): RepositoriesComponent {
        checkNotNull(repositoriesComponent) { "RepositoriesComponent was not initialized!" }
        return repositoriesComponent ?: throw NullPointerException("$this")
    }
}