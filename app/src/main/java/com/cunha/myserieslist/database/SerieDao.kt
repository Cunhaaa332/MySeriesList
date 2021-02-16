package com.cunha.myserieslist.database

import androidx.room.*
import com.cunha.myserieslist.model.Serie

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
}