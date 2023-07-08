package com.mw.example.daggermultimodule.di

import com.mw.example.daggermultimodule.App
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [AppModule::class]
)
@Singleton
abstract class AppComponent {

    abstract fun inject(app: App)

    companion object {
        @Volatile
        private var appComponent: AppComponent? = null

        fun initAndGet(): AppComponent {
            if (appComponent == null) {
                synchronized(AppComponent::class.java) {
                    if (appComponent == null) {
                        appComponent = DaggerAppComponent.builder().build()
                    }
                }
            }
            return appComponent ?: throw NullPointerException("$this")
        }
    }
}