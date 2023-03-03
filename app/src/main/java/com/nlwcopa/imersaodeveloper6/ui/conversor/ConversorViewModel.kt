package com.nlwcopa.imersaodeveloper6.ui.conversor

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class ConversorViewModel : ViewModel() {

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String>
        get() = _resultado

    private val _moedaSimbolo = MutableLiveData<String>()
    val moedaSimbolo: LiveData<String>
        get() = _moedaSimbolo

    private val _moedaHint = MutableLiveData<String>()
    val moedaHint: LiveData<String>
        get() = _moedaHint

    //Button Moedas
    private val _txtmoeda1 = MutableLiveData<String>()
    val txtMoeda1: LiveData<String>
        get() = _txtmoeda1

    private val _txtmoeda2 = MutableLiveData<String>()
    val txtMoeda2: LiveData<String>
        get() = _txtmoeda2

    //TIPO MOEDAS
    private val _moedaAtual = MutableLiveData<Int>()
    val moedaAtual: LiveData<Int>
        get() = _moedaAtual

    private val _moedaConverter = MutableLiveData<Int>()
    val moedaConverter: LiveData<Int>
        get() = _moedaConverter

    init {
        _moedaHint.value = "R$"
        _resultado.value = "0,00"
        _txtmoeda1.value = "REAL"
        _txtmoeda2.value = "DÓLAR"
    }

    fun checkArgsMoedas(moedaatual: Int, moedaconverter: Int) {

        //if (moedaatual != 0)
           // _moedaHint.value = selectMoeda(moedaatual.value)

        _moedaAtual.value = moedaatual
        _moedaConverter.value = moedaconverter

        _txtmoeda1.value = onButtonMoeda(moedaatual)
        _txtmoeda2.value = onButtonMoeda(moedaconverter)
    }

    //FUNCTIONS
    fun onConvert(value: Float) {
        //Toast.makeText(this, "Game has just finished", Toast.LENGTH_SHORT).show()
        var valorConvertido = (value / moedaReferencia(_moedaConverter))
        val random = valorConvertido
        valorConvertido = (random * 100.0).roundToInt() / 100.0
        _resultado.value = selectMoeda(_moedaConverter) + valorConvertido.toString()
    }

    fun moedaReferencia(moeda: LiveData<Int>): Double {
        val moedavalue = when (moeda.value) {
            11 -> 5.11
            12 -> 5.11
            13 -> 6.25
            14 -> 5.11
            15 -> 5.11
            16 -> 6.25
            else -> 0.0
        }

        return moedavalue
    }

    fun selectMoeda(tipo: LiveData<Int>): String {
        val moedaString = when (tipo.value) {
            11 -> "R$ "
            12 -> "US$ "
            13 -> "E$ "
            else -> " "
        }
        return moedaString
    }

    fun onButtonMoeda(moeda: Int): String {
        val moedaLabel = when (moeda) {
            11 -> "REAL"
            12 -> "DÓLAR"
            13 -> "EURO"
            14 -> "REAL"
            15 -> "DÓLAR"
            16 -> "EURO"
            else -> " "
        }

        return moedaLabel
    }

}