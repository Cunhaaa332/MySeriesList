package com.cunha.myserieslist.ui.serie.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cunha.myserieslist.api.ApiClient
import com.cunha.myserieslist.api.model.SerieApi
import com.cunha.myserieslist.database.EpisodioDao
import com.cunha.myserieslist.database.EpisodioDaoFirestore
import com.cunha.myserieslist.database.SerieDao
import com.cunha.myserieslist.database.SerieUtil
import com.cunha.myserieslist.model.Episodio
import com.cunha.myserieslist.model.Serie
import kotlinx.coroutines.launch

class DetailsSerieViewModel(private val episodioDao: EpisodioDao, private val key: String? = null) : ViewModel() {
    private val _episodios = MutableLiveData<List<Episodio>>()
    val episodios: LiveData<List<Episodio>> = _episodios

    private val _serieApi = MutableLiveData<SerieApi>()
    val serieApi: LiveData<SerieApi> = _serieApi

    init {
        pegaImdb()
    }


    fun allepisodios() {
        episodioDao.readEpisdioSerie(key!!).addOnSuccessListener {
            val episodiosFB = it.toObjects(Episodio::class.java)
            _episodios.value = episodiosFB
        }
    }

    fun pegaImdb(){
        var serieNova: SerieApi? = null
        viewModelScope.launch {
            var a = ApiClient.getProjectService()
            var nome = SerieUtil.serieSelecionada!!.nome
            var data = SerieUtil.serieSelecionada!!.dataLancamento
            serieNova = a.meAjuda("Vikings","2013", "6fcbeee2", "series")
                    //a.searchSerie(nome, data)
            _serieApi.value = serieNova
        }
    }

    fun deleteEpisodes(){
        for (episodio in episodios.value!!.iterator()){
            EpisodioDaoFirestore().delete(episodio)
        }
    }
}