package com.nlwcopa.imersaodeveloper6.ui.conversor

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConversorViewModel : ViewModel() {

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String>
        get() = _resultado

    private val _moedaSimbolo = MutableLiveData<String>()
    val moedaSimbolo: LiveData<String>
        get() = _moedaSimbolo

    init{
        _resultado.value = "0,00"
    }

    //FUNCTIONS
    fun onConvert() {
        var valorConvertido = 0.0
        Log.i("INFO", "Valor Convertido")
        //Toast.makeText(this, "Game has just finished", Toast.LENGTH_SHORT).show()

        valorConvertido = (30 * 5.11)
        _resultado.value = selectMoeda(1)+valorConvertido.toString()
    }

    fun selectMoeda(tipo: Int): String {
        val moedaString = when (tipo) {
            1 -> "R$ "
            2 -> "US$ "
            3 -> "E$ "
            else -> " "
        }
        return moedaString
    }
}