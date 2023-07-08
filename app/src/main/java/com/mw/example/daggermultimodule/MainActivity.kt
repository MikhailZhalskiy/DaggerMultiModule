package com.mw.example.daggermultimodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mw.example.feature_detail.api.di.DetailApi
import com.mw.example.feature_list.api.di.ListApi
import com.mw.example.usecases_api.di.UseCaseApi
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}