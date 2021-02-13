package com.cunha.myserieslist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Serie (
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val nome: String? = null,
    val dataLancamento: String? = null,
    val sinopse: String? = null,
    val nota: String? = null,
    val foto: String? = null
){
    override fun toString(): String =
            "Nome: $nome \n" +
            "Lançamento: $dataLancamento \n" +
            "Nota: $nota"
}

