package com.cunha.myserieslist.database

import com.cunha.myserieslist.model.Episodio


interface EpisodioDao {

     fun insert(episodio: Episodio)


     fun update(episodio: Episodio)


     fun delete(episodio: Episodio)


     fun all(): List<Episodio>


     fun read(key: Long): Episodio


     fun readEpisdioSerie(key: Long): List<Episodio>


     fun deleteEpisodesOfSerie(key: Long?)
}