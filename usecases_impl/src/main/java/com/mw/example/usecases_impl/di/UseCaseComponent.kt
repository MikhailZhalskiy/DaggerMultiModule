package com.mw.example.usecases_impl.di

import com.mw.example.usecases_api.di.UseCaseApi
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [UseCaseModule::class],
    dependencies = [UseCaseDependencies::class]
)
@Singleton
internal abstract class UseCaseComponent: UseCaseApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: UseCaseDependencies): UseCaseComponent
    }

    companion object {
        private var component: UseCaseComponent? = null

        fun initAndGet(dependencies: UseCaseDependencies): UseCaseComponent {
            if(component == null) {
                synchronized(UseCaseComponent::class.java) {
                    if (component == null) {
                        component = DaggerUseCaseComponent.factory().create(dependencies)
                    }
                }
            }
            return component ?: throw NullPointerException("$this")
        }
    }
}