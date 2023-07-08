package com.mw.example.feature_list.impl.di

import com.mw.example.feature_list.api.di.ListApi
import com.mw.example.injector.ComponentHolder

object ListComponentHolder: ComponentHolder<ListApi, ListDependencies> {

    @Volatile
    private var listComponent: ListComponent? = null

    override fun init(dependencies: ListDependencies) {
        if (listComponent == null) {
            synchronized(ListComponentHolder::class.java) {
                if (listComponent == null) {
                    listComponent = ListComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): ListApi = getComponent()

    override fun reset() {
        listComponent = null
    }

    internal fun getComponent(): ListComponent {
        checkNotNull(listComponent) { "ListComponent was not initialized!" }
        return listComponent ?: throw NullPointerException("$this")
    }
}