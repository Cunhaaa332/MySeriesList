package com.cunha.myserieslist.ui.serie.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.database.EpisodioDao
import java.lang.IllegalArgumentException

class DetailsSerieFragmentViewModelFactory(val episodioDao: EpisodioDao, val key: Long?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsSerieViewModel::class.java)){
            return DetailsSerieViewModel(/*episodioDao, key*/) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}
