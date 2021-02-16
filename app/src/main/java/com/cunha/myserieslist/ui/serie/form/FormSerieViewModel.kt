package com.cunha.myserieslist.ui.serie.form

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cunha.myserieslist.database.Repositorio
import com.cunha.myserieslist.database.SerieDao
import com.cunha.myserieslist.model.Serie
import kotlinx.coroutines.launch
import kotlin.Exception

class FormSerieViewModel(private val serieDao: SerieDao) : ViewModel() {

    //private var serie: Serie? = null

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    init {
        _status.value = false
        _message.value = null
    }

    fun saveSerie(nome: String, data: String, sinopse: String, nota: String, foto: String) {
        _status.value = false
        _message.value = "Aguarde a persistência..."
        viewModelScope.launch {
            val serie = Serie(nome, data, sinopse, nota, foto)

            try  {
                serieDao.insert(serie)
                _status.value = true
                _message.value = "Persistência realizada com êxito!"
            }catch (e: Exception){
                _message.value = "Falha na persistência!"
                Log.e("SQLite", "${e.message}")
            }
        }
    }
}