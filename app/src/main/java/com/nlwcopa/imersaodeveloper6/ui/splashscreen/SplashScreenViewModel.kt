package com.nlwcopa.imersaodeveloper6.ui.splashscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController

class SplashScreenViewModel : ViewModel() {

    fun onNavMain() {
        Log.i("INFO", "Vou para o Main")

    }

}