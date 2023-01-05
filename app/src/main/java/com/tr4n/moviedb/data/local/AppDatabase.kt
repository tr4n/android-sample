package com.tr4n.moviedb.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tr4n.moviedb.data.entity.MovieEntity
import com.tr4n.moviedb.data.local.AppDatabase.Companion.DATABASE_VERSION
import com.tr4n.moviedb.data.local.dao.MovieDao

@Database(
    entities = [
        MovieEntity::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        const val DATABASE_VERSION = 1
        private const val DB_NAME = "movie_db"

        fun build(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}
