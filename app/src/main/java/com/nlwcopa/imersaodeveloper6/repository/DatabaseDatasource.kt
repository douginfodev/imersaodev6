package com.nlwcopa.imersaodeveloper6.repository

import com.nlwcopa.imersaodeveloper6.database.Movies
import com.nlwcopa.imersaodeveloper6.database.dao.MovieDao

class DatabaseDatasource(
    private val moviesDao: MovieDao
) : MoviesRepository {
    //override fun loadAllByIds(movieIds: IntArray): List<Movies> {
    //    TODO("Not yet implemented")
    //}

   // override suspend fun insertAll(vararg movies: Movies) {
      //  TODO("Not yet implemented")
    //}

    override suspend fun insertMovie(
        nameMovie: String,
        refName: String,
        directorName: String,
        yearMovie: String
    ): Long {
        val movieEntity = Movies(
            id = 0,
            nameMovie = nameMovie,
            refName = refName,
            directorName = directorName,
            yearMovie = yearMovie
        )
        return moviesDao.insertMovie(movieEntity)
    }

    override suspend fun delete(movie: Movies) {
        TODO("Not yet implemented")
    }
}