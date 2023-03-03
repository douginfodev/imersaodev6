package com.nlwcopa.imersaodeveloper6.repository

import com.nlwcopa.imersaodeveloper6.database.Movie

interface MoviesRepository {
    //fun getAll(): LiveData<List<Movie>>
    fun loadAllByIds(movieIds: IntArray): List<Movie>
    suspend fun insertAll(vararg movies: Movie)
    suspend fun insertMovie(
        nameMovie: String,
        refName: String,
        directorName: String,
        yearMovie: String
    ): Long

    suspend fun delete(movie: Movie)
}