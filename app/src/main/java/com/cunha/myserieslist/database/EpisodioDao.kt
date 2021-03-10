package com.cunha.myserieslist.database

import com.cunha.myserieslist.model.Episodio
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot


interface EpisodioDao {

     fun insert(episodio: Episodio): Task<DocumentReference>


     fun update(episodio: Episodio): Task<Void>


     fun delete(episodio: Episodio): Task<Void>


     fun readEpisdioSerie(key: String): Task<QuerySnapshot>


     fun deleteEpisodesOfSerie(key: String?)
}