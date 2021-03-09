package com.cunha.myserieslist.ui.serie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cunha.myserieslist.database.SerieDao
import com.cunha.myserieslist.model.Serie
import kotlinx.coroutines.launch

class ListSerieViewModel(private val serieDao: SerieDao) : ViewModel() {
    private val _series = MutableLiveData<List<Serie>>()
    val series: LiveData<List<Serie>> = _series

    fun attListSeries() {
        serieDao.all().addOnSuccessListener {
            val seriesFB = it.toObjects(Serie::class.java)
            _series.value = seriesFB
        }.addOnFailureListener {

        }
        /*viewModelScope.launch {
            _series.value = serieDao.all()
        }*/
    }
}