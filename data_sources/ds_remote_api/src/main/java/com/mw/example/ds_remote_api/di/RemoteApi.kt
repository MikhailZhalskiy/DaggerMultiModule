package com.mw.example.ds_remote_api.di

import com.mw.example.ds_remote_api.RemoteService
import com.mw.example.injector.BaseApi

interface RemoteApi: BaseApi {
    fun getRemoteService(): RemoteService
}