package com.nlwcopa.imersaodeveloper6.ui.movielist

import android.app.Application
import androidx.lifecycle.ViewModel
import com.nlwcopa.imersaodeveloper6.repository.MoviesRepository

class MovieListViewModel(
    private val repository: MoviesRepository,
    private val application: Application
) : ViewModel() {
 val allMoviesEvent = repository.getAllMovies()
}