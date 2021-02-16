package com.cunha.myserieslist.model

import androidx.room.Embedded
import androidx.room.Relation

class SerieAndEpisodio (
        @Embedded val serie: Serie,

        @Relation(
                parentColumn = "id",
                entityColumn = "serieId"
        )
        val episodios: List<Episodio>
){
        override fun toString(): String = "Serie: " + "${serie.nome}" + "Episodios: " + "${episodios}"
}