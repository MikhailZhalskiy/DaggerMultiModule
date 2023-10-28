package com.mw.example.daggermultimodule

import android.app.Application
import com.mw.example.daggermultimodule.di.AppComponent
import com.mw.example.injector.ComponentDependenciesProvider
import com.mw.example.injector.HasComponentDependencies
import javax.inject.Inject

class App: Application(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        appComponent = AppComponent.initAndGet()
        appComponent.inject(this)
    }

    companion object {
        private lateinit var appComponent: AppComponent
        val instance: AppComponent get() = appComponent
    }
}
