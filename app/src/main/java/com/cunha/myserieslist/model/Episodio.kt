package com.cunha.myserieslist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Episodio(
    val nome: String? = null,
    val numeroEp: String? = null,
    val sinopse: String? = null,
    val nota: String? = null,
    val serieId : Long? = null,

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
){
    override fun toString(): String = "Nome: $nome"

}