package com.tr4n.moviedb.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tr4n.moviedb.data.entity.CastEntity
import com.tr4n.moviedb.data.entity.MovieEntity
import com.tr4n.moviedb.domain.model.Cast

@Dao
interface CastDao {
    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<Cast>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: CastEntity)

    @Query("SELECT * FROM movies WHERE id = :movieId")
    suspend fun get(movieId: String): CastEntity

    @Query("DELETE FROM movies WHERE id = :movieId")
    suspend fun delete(movieId: String)
}
