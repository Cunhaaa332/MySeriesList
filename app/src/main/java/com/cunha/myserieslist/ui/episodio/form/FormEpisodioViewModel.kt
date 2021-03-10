package com.cunha.myserieslist.ui.episodio.form

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cunha.myserieslist.database.EpisodioDao
import com.cunha.myserieslist.database.EpisodioUtil
import com.cunha.myserieslist.database.SerieUtil
import com.cunha.myserieslist.model.Episodio
import kotlinx.coroutines.launch

class FormEpisodioViewModel(val episodioDao: EpisodioDao) : ViewModel() {
    fun saveEpisodio(nome: String, numeroEp: String, sinopse: String, nota: String) {

        viewModelScope.launch {
            try  {
                val serieId = SerieUtil.serieSelecionada?.id
                val episodio = Episodio(nome, numeroEp, sinopse, nota, serieId)
                if(EpisodioUtil.episodioSelecionado != null) {
                    episodio.id = EpisodioUtil.episodioSelecionado!!.id
                    episodioDao.update(episodio)
                } else
                    episodioDao.insert(episodio)
            }catch (e: Exception){
                Log.e("FirBase", "${e.message}")
            }
        }
    }
}