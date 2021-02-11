package com.cunha.myserieslist.model

class Serie (
    val nome: String? = null,
    val dataLancamento: String? = null,
    val sinopse: String? = null,
    val nota: String? = null
){
    override fun toString(): String =
            "Nome: $nome \n" +
            "Lançamento: $dataLancamento \n" +
            "Nota: $nota"
}

