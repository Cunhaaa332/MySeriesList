package com.cunha.myserieslist.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentReference


class Episodio(
    val nome: String? = null,
    val numeroEp: String? = null,
    val sinopse: String? = null,
    val nota: String? = null,
    val serieId : String? = null,
    @DocumentId
    var id: String? = null
){
    override fun toString(): String = "Nome: $nome"

}