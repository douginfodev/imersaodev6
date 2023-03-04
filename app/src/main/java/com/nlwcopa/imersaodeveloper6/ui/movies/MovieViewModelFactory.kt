package com.nlwcopa.imersaodeveloper6.ui.movies

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nlwcopa.imersaodeveloper6.repository.MoviesRepository

class MovieViewModelFactory(
    private val repository: MoviesRepository,
    private val application: Application
) : ViewModelProvider.Factory  {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.i("aaa","aaa")

        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {

            return MovieViewModel(repository, application) as T
        }
        throw IllegalArgumentException("ViewModel class desconhecida")
    }



    /*
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
   if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
       return ScoreViewModel(finalScore) as T
   }
   throw IllegalArgumentException("Unknown ViewModel class")
}
    */

}