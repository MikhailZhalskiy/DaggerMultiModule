package com.mw.example.usecases_impl.di

import com.mw.example.injector.ComponentHolder
import com.mw.example.usecases_api.di.UseCaseApi

object UseCaseComponentHolder: ComponentHolder<UseCaseApi, UseCaseDependencies> {

    @Volatile
    private var useCaseComponent: UseCaseComponent? = null

    override fun init(dependencies: UseCaseDependencies) {
        if (useCaseComponent == null) {
            synchronized(UseCaseComponentHolder::class.java) {
                if (useCaseComponent == null) {
                    useCaseComponent = UseCaseComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): UseCaseApi = getComponent()

    override fun reset() {
        useCaseComponent = null
    }

    internal fun getComponent(): UseCaseComponent {
        checkNotNull(useCaseComponent) { "UseCaseComponent was not initialized!" }
        return useCaseComponent ?: throw NullPointerException("$this")
    }
}