package com.cunha.myserieslist.ui.serie.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.database.SerieDao
import java.lang.IllegalArgumentException

class FormSerieViewModelFactory(val serieDao: SerieDao) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FormSerieViewModel::class.java)){
            return FormSerieViewModel(serieDao) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}