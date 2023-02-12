package com.nlwcopa.imersaodeveloper6.ui.conversor.moedas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoedasViewModel : ViewModel() {
//  android:paddingTop="?attr/actionBarSize"

//    private var _moedas1 = MutableLiveData<ArrayList<Boolean>>()
//    val moedas1: LiveData<ArrayList<Boolean>>
//        get() = _moedas1

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

    //Moedas 2
    private val _rdbbtn4 = MutableLiveData<Boolean>()
    val rdbbtn4: LiveData<Boolean>
        get() = _rdbbtn4

    private val _rdbbtn5 = MutableLiveData<Boolean>()
    val rdbbtn5: LiveData<Boolean>
        get() = _rdbbtn5

    private val _rdbbtn6 = MutableLiveData<Boolean>()
    val rdbbtn6: LiveData<Boolean>
        get() = _rdbbtn6

     //TIPO MOEDAS
    private val _tipoMoeda1 = MutableLiveData<Int>()
    val tipoMoeda1: LiveData<Int>
        get() = _tipoMoeda1

    private val _tipoMoeda2 = MutableLiveData<Int>()
    val tipoMoeda2: LiveData<Int>
        get() = _tipoMoeda2

    var moedaAtualSelected: Int = 0
        get() = field
        set(value) {
            field = value
        }

    var moedaConverterSelected: Int = 0
        get() = field
        set(value) {
            field = value
        }

    init {
        _rdbbtn1.value = false
        _rdbbtn2.value = false
        _rdbbtn3.value = false

        _rdbbtn4.value = false
        _rdbbtn5.value = false
        _rdbbtn6.value = false
    }

    fun onStartFragment(tpMoeda1 : Int , tpMoeda2 : Int,){
        this.moedaAtualSelected = tpMoeda1
        this.moedaConverterSelected = tpMoeda2
        _tipoMoeda1.value = tpMoeda1
        _tipoMoeda2.value = tpMoeda2
        onChangeColor(tpMoeda1)
        onChangeColorConvert(tpMoeda2)
    }

    fun onChangeColor(op: Int) {
        _rdbbtn1.value = false
        _rdbbtn2.value = false
        _rdbbtn3.value = false
        moedaAtualSelected = op
        _tipoMoeda1.value = op

        when (op) {
            11 -> _rdbbtn1.value = true
            12 -> _rdbbtn2.value = true
            13 -> _rdbbtn3.value = true
            else -> _rdbbtn1.value = true
        }
    }

    fun onChangeColorConvert(op: Int) {
        _rdbbtn4.value = false
        _rdbbtn5.value = false
        _rdbbtn6.value = false
        moedaConverterSelected = op
        _tipoMoeda2.value = op

        when (op) {
            14 -> _rdbbtn4.value = true
            15 -> _rdbbtn5.value = true
            16 -> _rdbbtn6.value = true
            else -> _rdbbtn4.value = true
        }
    }
}