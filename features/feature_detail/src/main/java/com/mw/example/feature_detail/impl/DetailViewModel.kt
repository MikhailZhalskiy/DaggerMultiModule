package com.mw.example.feature_detail.impl

import androidx.lifecycle.ViewModel
import com.mw.example.usecases_api.GetPerson
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val getPerson: GetPerson
) : ViewModel() {

    fun person(): String = getPerson().toString()
}