package com.mw.example.repositories_impl.di

import com.mw.example.ds_remote_api.RemoteService
import com.mw.example.injector.BaseDependencies

interface RepositoriesDependencies: BaseDependencies {
    val remoteService: RemoteService
}