package com.cunha.myserieslist.database

import androidx.room.*
import com.cunha.myserieslist.model.Episodio
import com.cunha.myserieslist.model.Serie

@Dao
interface EpisodioDao {
    @Insert
    suspend fun insert(episodio: Episodio)

    @Update
    suspend fun update(episodio: Episodio)

    @Delete
    suspend fun delete(episodio: Episodio)

    @Query("SELECT * FROM Episodio")
    suspend fun all(): List<Episodio>

    @Query("SELECT * FROM Episodio WHERE id = :key")
    suspend fun read(key: Long): Episodio

    @Query("SELECT * FROM Episodio WHERE serieId = :key")
    suspend fun readEpisdioSerie(key: Long): List<Episodio>

    @Query("DELETE FROM Episodio WHERE serieId = :key")
    suspend fun deleteEpisodesOfSerie(key: Long?)
}