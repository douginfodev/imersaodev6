package com.nlwcopa.imersaodeveloper6.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nlwcopa.imersaodeveloper6.database.Movies

@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: Movies) : Long

    @Update
    suspend fun update(movie: Movies)

    @Query("DELETE FROM movies")
    suspend fun deleteAll()

    @Query("DELETE FROM movies WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM movies")
    fun getAll(): LiveData<List<Movies>>
}