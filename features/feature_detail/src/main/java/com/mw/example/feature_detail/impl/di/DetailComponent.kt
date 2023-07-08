package com.mw.example.feature_detail.impl.di

import com.mw.example.feature_detail.api.di.DetailApi
import com.mw.example.feature_detail.impl.DetailFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [DetailModule::class, DetailViewModelModule::class],
    dependencies = [DetailDependencies::class]
)
@Singleton
internal abstract class DetailComponent: DetailApi {

    abstract fun inject(fragment: DetailFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: DetailDependencies): DetailComponent
    }

    companion object {
        private var component: DetailComponent? = null

        fun initAndGet(dependencies: DetailDependencies): DetailComponent {
            if(component == null) {
                synchronized(DetailComponent::class.java) {
                    if (component == null) {
                        component = DaggerDetailComponent.factory().create(dependencies)
                    }
                }
            }
            return component ?: throw NullPointerException("$this")
        }
    }
}