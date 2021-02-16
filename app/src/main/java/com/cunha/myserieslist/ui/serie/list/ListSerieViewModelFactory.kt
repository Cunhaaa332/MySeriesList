package com.cunha.myserieslist.ui.serie.list

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.database.SerieDao
import java.lang.IllegalArgumentException

class ListSerieViewModelFactory(private val serieDao: SerieDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListSerieViewModel::class.java))
            return ListSerieViewModel (serieDao) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}