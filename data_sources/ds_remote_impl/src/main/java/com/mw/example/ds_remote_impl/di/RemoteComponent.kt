package com.mw.example.ds_remote_impl.di

import com.mw.example.ds_remote_api.di.RemoteApi
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [RemoteModule::class],
    dependencies = [RemoteDependencies::class]
)
@Singleton
abstract class RemoteComponent: RemoteApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: RemoteDependencies): RemoteComponent
    }

    companion object {
        private var component: RemoteComponent? = null

        fun initAndGet(dependencies: RemoteDependencies): RemoteComponent {
            if(component == null) {
                synchronized(RemoteComponent::class.java) {
                    if (component == null) {
                        component = DaggerRemoteComponent.factory().create(dependencies)
                    }
                }
            }
            return component ?: throw NullPointerException("$this")
        }
    }
}