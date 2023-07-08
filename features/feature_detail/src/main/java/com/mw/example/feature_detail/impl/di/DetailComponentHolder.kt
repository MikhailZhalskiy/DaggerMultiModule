package com.mw.example.feature_detail.impl.di

import com.mw.example.feature_detail.api.di.DetailApi
import com.mw.example.injector.ComponentHolder

object DetailComponentHolder: ComponentHolder<DetailApi, DetailDependencies> {

    private var detailComponent: DetailComponent? = null

    override fun init(dependencies: DetailDependencies) {
        if(detailComponent == null) {
            synchronized(DetailComponentHolder::class.java) {
                if (detailComponent == null) {
                    detailComponent = DetailComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): DetailApi = getComponent()

    override fun reset() {
        detailComponent = null
    }

    internal fun getComponent(): DetailComponent {
        checkNotNull(detailComponent) { "DetailComponent was not initialized!" }
        return detailComponent ?: throw NullPointerException("$this")
    }
}