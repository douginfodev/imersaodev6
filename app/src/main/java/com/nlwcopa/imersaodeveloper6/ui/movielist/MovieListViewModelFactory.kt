package com.nlwcopa.imersaodeveloper6.ui.movielist

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nlwcopa.imersaodeveloper6.repository.MoviesRepository

class MovieListViewModelFactory (
    private val repository: MoviesRepository,
    private val application: Application
    ) : ViewModelProvider.Factory  {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            Log.i("Movie List","Movie List Factpry")

            if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
                return MovieListViewModel(repository, application) as T
            }
            throw IllegalArgumentException("ViewModel class desconhecida")
        }



    }