package com.cunha.myserieslist.ui.serie.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cunha.myserieslist.database.EpisodioDao
import com.cunha.myserieslist.database.SerieDao
import com.cunha.myserieslist.model.Episodio
import com.cunha.myserieslist.model.Serie
import kotlinx.coroutines.launch

class DetailsSerieViewModel(/*private val episodioDao: EpisodioDao, private val key: Long? = null*/) : ViewModel() {
    private val _episodios = MutableLiveData<List<Episodio>>()
    val episodios: LiveData<List<Episodio>> = _episodios

    /*fun allepisodios() {
        viewModelScope.launch {
            _episodios.value = episodioDao.readEpisdioSerie(key!!)
        }
    }*/
}