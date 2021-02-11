package com.cunha.myserieslist.data

import com.cunha.myserieslist.model.Serie

class Repositorio {

    private val series = listOf(
        Serie("Breaking Bad", "20/01/2008", "Um professor de quimica que vende meta.", "10"),
        Serie("Vinkings", "03/03/2013", "Uns Vinkings que caem no soco.", "8"),
        Serie("Cobra Kai", "02/05/2018", "Uns jovens e uns velho lutando Karate.", "9")
    )

    fun all(): List<Serie> = series

    companion object {
        private var instance: Repositorio? = null
        fun getInstance(): Repositorio{
            if (instance == null)
                instance = Repositorio()
            return instance as Repositorio
        }
    }

}