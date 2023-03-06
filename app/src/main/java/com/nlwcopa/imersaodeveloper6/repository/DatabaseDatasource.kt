package com.nlwcopa.imersaodeveloper6.repository

import androidx.lifecycle.LiveData
import com.nlwcopa.imersaodeveloper6.database.Movies
import com.nlwcopa.imersaodeveloper6.database.dao.MovieDao

class DatabaseDatasource(
    private val movieDao: MovieDao
    ) : MoviesRepository {

    override suspend fun insertMovies(
        nameMovie: String,
        refName: String,
        directorName: String,
        yearMovie: String
    ): Long {

        val movie = Movies(
            id = 0,
            nameMovie =  nameMovie,
            refName = refName,
            directorName =  directorName,
            yearMovie = yearMovie
        )

        return movieDao.insert(movie)
    }

    override suspend fun updateMovies(
        id: Int,
        nameMovie: String,
        refName: String,
        directorName: String,
        yearMovie: String
    ) {
        val movie = Movies(
            id = id,
            nameMovie =  nameMovie,
            refName = refName,
            directorName =  directorName,
            yearMovie = yearMovie
        )

         movieDao.update(movie)
    }

    override suspend fun deleteMovies(id: Int) {
        movieDao.delete(id)
    }

    override suspend fun deleteAllMovies() {
        movieDao.deleteAll()
    }

    override fun getAllMovies(): LiveData<List<Movies>> {
        return movieDao.getAll()
    }

}