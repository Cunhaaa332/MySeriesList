package com.cunha.myserieslist.api.model

class SerieApi (
        var name: String? = null,
        var rating: Rating? = null,
        )

class Rating (
        var average: Float? = null
)
