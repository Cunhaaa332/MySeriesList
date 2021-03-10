package com.cunha.myserieslist.database

import com.cunha.myserieslist.model.Serie
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot

class SerieDaoFirestore : SerieDao {

    private val collection = FirebaseFirestore.getInstance().collection("series")

    override fun insertOrUpdate(serie: Serie): Task<DocumentReference> {
        return collection.add(serie)
    }

    override  fun delete(serie: Serie): Task<Void> {
        return collection.document(serie.id!!).delete()
    }

    override  fun all(): Task<QuerySnapshot> {
        return collection.get()
    }

    override fun read(key: String): Query {
        return collection.whereEqualTo("id", key!!)
    }

    override fun edit(serie: Serie): Task<Void> {
        return collection.document(serie.id!!).set(serie)
    }
}