package com.cunha.myserieslist.ui.serie.list

import android.util.Log
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
        serieDao.all().addSnapshotListener{ value, error ->
            if(error != null){
                Log.i("FirebaseFirestore", "${error.message}")
            } else {
                if (value != null && !value.isEmpty){
                    _series.value = value.toObjects(Serie::class.java)
                }
            }

        }
    }
}