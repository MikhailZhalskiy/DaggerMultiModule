package com.mw.example.injector

interface ComponentHolder<Component: BaseApi, Dependencies: BaseDependencies> {

    fun init(dependencies: Dependencies)

    fun get(): Component

    fun reset()
}

interface BaseDependencies

interface BaseApi