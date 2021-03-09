package com.cunha.myserieslist.model

import com.google.firebase.firestore.DocumentId

class Serie (

    @DocumentId
    val nome: String? = null,
    val dataLancamento: String? = null,
    val sinopse: String? = null,
    val nota: String? = null,
    val foto: String? = null,

){
    override fun toString(): String =
        "Nome: $nome \n" +
        "Lançamento: $dataLancamento \n" +
        "Nota: $nota"
}

