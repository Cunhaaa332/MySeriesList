package com.cunha.myserieslist.ui.serie.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cunha.myserieslist.data.Repositorio
import com.cunha.myserieslist.model.Serie
import kotlinx.coroutines.launch

class FormSerieViewModel : ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    init {
        _status.value = false
        _message.value = null
    }

    fun saveSerie(nome: String, data: String, sinopse: String, nota: String) {
        _status.value = false
        _message.value = "Aguarde a persistência..."
        viewModelScope.launch {
            val serie = Serie(nome, data, sinopse, nota)
            val retorno = Repositorio.getInstance().store(serie)

            if (retorno) {
                _status.value = true
                _message.value = "Persistência realizada com êxito!"
            }else
                _message.value = "Falha na persistência!"
        }
    }
}