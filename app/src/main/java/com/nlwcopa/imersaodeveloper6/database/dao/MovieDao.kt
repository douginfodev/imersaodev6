package com.nlwcopa.imersaodeveloper6.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.nlwcopa.imersaodeveloper6.database.Movies

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getAll(): List<Movies>

//    @Query("SELECT * FROM movies WHERE id IN (:movieIds)")
    //fun loadAllByIds(movieIds: IntArray): List<Movie>

//   / @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): Movie

    @Insert
    suspend fun insertAll(vararg movies: Movies)

    @Insert
    suspend fun insertMovie(name: Movies) : Long

    @Delete
    suspend fun delete(movie: Movies)
}