package com.pawan.sage.viewmodeltest.viewmodel

import androidx.lifecycle.ViewModel

class FirstFragmentViewModel: ViewModel() {

    var number = 0
    fun addNumber(){
        number++
    }
}