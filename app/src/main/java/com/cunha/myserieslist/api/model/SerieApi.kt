package com.cunha.myserieslist.api.model

class SerieApi (
        var Title: String? = null,
        var imdbRating: String? = null,
        var Year: String? = null
        ){
        override fun toString(): String {
                return "$imdbRating"
        }
}