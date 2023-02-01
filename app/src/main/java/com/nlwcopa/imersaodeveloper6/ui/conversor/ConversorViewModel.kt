package com.nlwcopa.imersaodeveloper6.ui.conversor

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConversorViewModel : ViewModel() {

    private val _resultado = MutableLiveData<String>().apply {
        value = "Crie seu próprio bolão da Copa e compartilhe entre amigos!"
    }
    val resultado: LiveData<String> = _resultado

    //FUNCTIONS
    fun onConvert() {
        Log.i("INFO","Valor Convertido")
        //Toast.makeText(this, "Game has just finished", Toast.LENGTH_SHORT).show()
    }


}