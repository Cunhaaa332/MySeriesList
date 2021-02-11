package com.cunha.myserieslist.ui.serie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cunha.myserieslist.data.Repositorio
import com.cunha.myserieslist.model.Serie
import kotlinx.coroutines.launch

class ListSerieViewModel : ViewModel() {
    private val _series = MutableLiveData<List<Serie>>()
    val series: LiveData<List<Serie>> = _series

    fun attListSeries() {
        viewModelScope.launch {
            _series.value = Repositorio.getInstance().all()
        }
    }
}