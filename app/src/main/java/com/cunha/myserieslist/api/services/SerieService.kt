package com.cunha.myserieslist.api.services

import com.cunha.myserieslist.api.model.SerieApi
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SerieService {
    @GET("singlesearch/shows?")
    suspend fun searchSerie(
            @Query("q")title: String?,
            //@Query("y")year:String?
            ) : SerieApi

//    @GET("?apikey={apiKey}&type={type}&t={title}&y={year}")
//    suspend fun meAjuda(
//        @Path("title") title: String,
//        @Path("year") year: String,
//        @Path ("apikey") apiKey: String,
//        @Path ("type") type: String,): SerieApi
}