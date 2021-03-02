package com.cunha.myserieslist.ui.serie.form

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cunha.myserieslist.database.SerieDao
import com.cunha.myserieslist.database.SerieUtil
import com.cunha.myserieslist.model.Serie
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch
import kotlin.Exception

class FormSerieViewModel(private val serieDao: SerieDao) : ViewModel() {

    private val _imageSerie = MutableLiveData<Bitmap>()
    val imageSerie: LiveData<Bitmap> = _imageSerie
    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    init {
        _status.value = false
        _message.value = null
        loadImageSerie()
    }

    fun saveSerie(nome: String, data: String, sinopse: String, nota: String, foto: String) {
        _status.value = false
        _message.value = "Aguarde a persistência..."

        viewModelScope.launch {
            try  {
                val serie = Serie(nome, data, sinopse, nota, foto)
                if(SerieUtil.serieSelecionada != null) {
                    serie.id = SerieUtil.serieSelecionada!!.id
                    serieDao.update(serie)
                } else
                    serieDao.insert(serie)

                _status.value = true
                _message.value = "Persistência realizada com êxito!"
            }catch (e: Exception){
                _message.value = "Falha na persistência!"
                Log.e("SQLite", "${e.message}")
            }
        }
    }

    fun loadImageSerie(){
        val fireBaseStorage = FirebaseStorage.getInstance()
        val storageReference = fireBaseStorage.reference
        val fileReference = storageReference.child("troll.jpg")
        val task = fileReference.getBytes(1024*1024)
        task.addOnSuccessListener {
            val bitmap = BitmapFactory.decodeByteArray(it, 0, it.size)
            _imageSerie.value = bitmap
        }.addOnFailureListener {
            _message.value = "Imagem não pode ser carregada: ${it.message}"
        }
    }
}