package com.cunha.myserieslist.ui.serie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cunha.myserieslist.data.Repositorio
import com.cunha.myserieslist.model.Serie

class ListSerieViewModel : ViewModel() {
    private val _series = MutableLiveData<List<Serie>>()
    val series: LiveData<List<Serie>> = _series

    fun attListSeries() {
        _series.value = Repositorio.getInstance().all()
    }
}