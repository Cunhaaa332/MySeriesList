package com.cunha.myserieslist.api

import com.cunha.myserieslist.api.services.SerieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var instance: Retrofit? = null
    private fun getInstance(): Retrofit{
        if (instance == null){
            instance = Retrofit.Builder().baseUrl("http://api.tvmaze.com").addConverterFactory(GsonConverterFactory.create()).build()
            // "http://www.omdbapi.com"
        }
        return instance as Retrofit
    }

    fun getProjectService(): SerieService {
        var retrofit = getInstance()
        return retrofit.create(SerieService::class.java)
    }
}