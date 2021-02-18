package com.cunha.myserieslist.database

import androidx.room.*
import com.cunha.myserieslist.model.Serie
import com.cunha.myserieslist.model.SerieAndEpisodio

@Dao
interface SerieDao {
    @Insert
    suspend fun insert(serie: Serie)

    @Update
    suspend fun update(serie: Serie)

    @Delete
    suspend fun delete(serie: Serie)

    @Query("SELECT * FROM Serie")
    suspend fun all(): List<Serie>

    @Transaction
    @Query("SELECT * FROM Serie WHERE id = :key")
    suspend fun read(key: Long): Serie
}