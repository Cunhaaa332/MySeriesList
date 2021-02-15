package com.cunha.myserieslist.database

import androidx.room.Dao
import androidx.room.Insert
import com.cunha.myserieslist.model.Serie

@Dao
interface SerieDao {
    @Insert
    suspend fun insert(serie: Serie)
}