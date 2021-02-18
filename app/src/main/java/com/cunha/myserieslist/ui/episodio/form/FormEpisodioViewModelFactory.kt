package com.cunha.myserieslist.ui.episodio.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.database.EpisodioDao
import com.cunha.myserieslist.ui.serie.form.FormSerieViewModel
import java.lang.IllegalArgumentException

class FormEpisodioViewModelFactory(val episodioDao: EpisodioDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FormEpisodioViewModel::class.java)){
            return FormEpisodioViewModel(episodioDao) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}