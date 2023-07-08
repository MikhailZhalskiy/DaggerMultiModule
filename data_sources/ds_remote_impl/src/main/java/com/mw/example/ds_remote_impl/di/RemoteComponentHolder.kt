package com.mw.example.ds_remote_impl.di

import com.mw.example.ds_remote_api.di.RemoteApi
import com.mw.example.injector.ComponentHolder

object RemoteComponentHolder: ComponentHolder<RemoteApi, RemoteDependencies> {

    @Volatile
    private var remoteComponent: RemoteComponent? = null

    override fun init(dependencies: RemoteDependencies) {
        if (remoteComponent == null) {
            synchronized(RemoteComponentHolder::class.java) {
                if (remoteComponent == null) {
                    remoteComponent = RemoteComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): RemoteApi = getComponent()

    override fun reset() {
        remoteComponent = null
    }

    internal fun getComponent(): RemoteComponent {
        checkNotNull(remoteComponent) { "RemoteComponent was not initialized!" }
        return remoteComponent ?: throw NullPointerException("$this")
    }
}
