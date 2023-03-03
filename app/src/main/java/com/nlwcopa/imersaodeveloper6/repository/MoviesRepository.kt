package com.nlwcopa.imersaodeveloper6.repository

import androidx.lifecycle.LiveData
import com.nlwcopa.imersaodeveloper6.database.Movies

interface MoviesRepository {

    suspend fun insertMovies(
        nameMovie: String,
        refName: String,
        directorName: String,
        yearMovie: String
    ): Long

    suspend fun updateMovies(
        id: Int,
        nameMovie: String,
        refName: String,
        directorName: String,
        yearMovie: String
    )

    suspend fun deleteMovies(id: Int)

    suspend fun deleteAllMovies()

    suspend fun getAllMovies(): LiveData<List<Movies>>

}