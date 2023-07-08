package com.mw.example.feature_list.impl

import androidx.lifecycle.ViewModel
import com.mw.example.usecases_api.GetListPerson
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val getListPerson: GetListPerson
) : ViewModel() {

    fun listPerson(): String = getListPerson().toString()
}