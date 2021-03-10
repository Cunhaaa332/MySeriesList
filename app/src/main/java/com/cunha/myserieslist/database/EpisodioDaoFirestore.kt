package com.cunha.myserieslist.database

import com.cunha.myserieslist.model.Episodio
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot

class EpisodioDaoFirestore: EpisodioDao {

    private val collection = FirebaseFirestore.getInstance().collection("episodios")

    override fun insert(episodio: Episodio): Task<DocumentReference> {
        return collection.add(episodio)
    }

    override fun update(episodio: Episodio): Task<Void> {
        return collection.document(episodio.id!!).set(episodio)
    }

    override fun delete(episodio: Episodio): Task<Void> {
        return collection.document(episodio.id!!).delete()
    }

    override fun readEpisdioSerie(key: String): Task<QuerySnapshot> {
       return collection.whereEqualTo("serieId", key).get()
    }
}