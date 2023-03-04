package com.nlwcopa.imersaodeveloper6.ui.movies

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.nlwcopa.imersaodeveloper6.R
import com.nlwcopa.imersaodeveloper6.database.dao.MovieDao
import com.nlwcopa.imersaodeveloper6.repository.MoviesRepository
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MoviesRepository,
    private val application: Application
) : ViewModel() {


    private val _movieStateEventData = MutableLiveData<MovieState>()
    val movieStateEventData: LiveData<MovieState>
        get() = _movieStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _messageEventData

    //Log.i("OK", "AAA")

    fun addMovies(
        id: Int,
        nameMovie: String,
        refName: String,
        directorName: String,
        yearMovie: String
    ) = viewModelScope.launch {

        try {
            val ida = repository.insertMovies(nameMovie, refName, directorName, yearMovie)

            if (ida > 0) {
                _movieStateEventData.value = MovieState.Inserted
                _messageEventData.value = R.string.msg_gravar
                Log.i("OK", "FILME ADICIONADO COM SUCESSO")
            }
        } catch (ex: Exception) {
            _messageEventData.value = R.string.msg_error
            Log.e(TAG, ex.toString())

            // Log.i("OK", "FILME ADICIONADO COM SUCESSO")
        }
    }
        sealed class MovieState {
            object Inserted : MovieState()
        }

        companion object {
        private val TAG = MovieViewModel::class.java.simpleName
    }

        /**
         * Factory class to instantiate the [ViewModel] instance.

        class MovieViewModelFactory(private val movieDao: MovieDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
        @Suppress("UNCHECKED_CAST")
        return MovieViewModel(MovieDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
        }*/

    }