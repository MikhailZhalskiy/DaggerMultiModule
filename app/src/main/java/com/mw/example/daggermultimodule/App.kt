package com.mw.example.daggermultimodule

import android.app.Application
import com.mw.example.daggermultimodule.di.AppComponent
import com.mw.example.feature_detail.api.di.DetailApi
import com.mw.example.feature_list.api.di.ListApi
import javax.inject.Inject
import javax.inject.Provider

class App: Application() {

    @Inject
    lateinit var listApi: Provider<ListApi>

    @Inject
    lateinit var detailApi: Provider<DetailApi>

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        appComponent = AppComponent.initAndGet()
        appComponent.inject(this)
        listApi.get()
        detailApi.get()
    }

    companion object {
        private lateinit var appComponent: AppComponent
        val instance: AppComponent get() = appComponent
    }
}
