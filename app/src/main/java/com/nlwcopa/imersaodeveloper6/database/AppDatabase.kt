package com.nlwcopa.imersaodeveloper6.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nlwcopa.imersaodeveloper6.database.dao.MovieDao

@Database(entities = [Movies::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract val movieDao : MovieDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "imvdev6"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}