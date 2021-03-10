package com.cunha.myserieslist.database

import com.cunha.myserieslist.model.Serie
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot


interface SerieDao {

     fun insertOrUpdate(serie: Serie) : Task<DocumentReference>

     fun delete(serie: Serie) : Task<Void>

     fun all(): Task<QuerySnapshot>

     fun read(key: String): Query

     fun edit(serie: Serie): Task<Void>
}