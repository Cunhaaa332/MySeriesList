package com.cunha.myserieslist.model




class Episodio(
    val nome: String? = null,
    val numeroEp: String? = null,
    val sinopse: String? = null,
    val nota: String? = null,
    val serieNome : String? = null,


    var id: Long? = null
){
    override fun toString(): String = "Nome: $nome"

}