package com.nlwcopa.imersaodeveloper6.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movies(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "namemovie")
    val nameMovie:    String,
    @ColumnInfo(name = "refname")
    val refName:         String,
    @ColumnInfo(name = "directorname")
    val directorName: String,
    @ColumnInfo(name = "yearmovie")
    val yearMovie:      String
)
