package com.cunha.myserieslist.database

import androidx.room.*
import com.cunha.myserieslist.model.Serie
import com.cunha.myserieslist.model.SerieAndEpisodio
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot


interface SerieDao {

     fun insertOrUpdate(serie: Serie) : Task<Void>

     fun delete(serie: Serie) : Task<Void>

     fun all(): Task<QuerySnapshot>

     fun read(key: Long): Serie
}