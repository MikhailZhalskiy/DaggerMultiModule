package com.mw.example.ds_remote_impl.di

import com.mw.example.ds_remote_api.RemoteService
import com.mw.example.ds_remote_impl.RemoteServiceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RemoteModule {

    @Singleton
    @Binds
    fun bindsRemoteService(remoteService: RemoteServiceImpl): RemoteService
}