package com.nlwcopa.imersaodeveloper6.ui.conversor.moedas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoedasViewModel : ViewModel() {

//  android:paddingTop="?attr/actionBarSize"
//private val moedas1 = arrayOf(true,false,false)
//private val moedas2 = arrayListOf(false,true,false)
private var _moedas1 = MutableLiveData<ArrayList<Boolean>>()
    val moedas1: LiveData<ArrayList<Boolean>>
        get() = _moedas1

  //Moedas 1
    private val _rdbbtn1 = MutableLiveData<Boolean>()
    val rdbbtn1: LiveData<Boolean>
        get() = _rdbbtn1

    private val _rdbbtn2 = MutableLiveData<Boolean>()
    val rdbbtn2: LiveData<Boolean>
        get() = _rdbbtn2

    private val _rdbbtn3 = MutableLiveData<Boolean>()
    val rdbbtn3: LiveData<Boolean>
        get() = _rdbbtn3

    init{
        _rdbbtn1.value = true
        _rdbbtn2.value = false
        _rdbbtn3.value = false
    }

}