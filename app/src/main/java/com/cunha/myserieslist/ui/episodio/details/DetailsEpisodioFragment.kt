package com.cunha.myserieslist.ui.episodio.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.cunha.myserieslist.R
import com.cunha.myserieslist.database.AppDatabase
import com.cunha.myserieslist.database.EpisodioUtil
import com.cunha.myserieslist.database.SerieDaoFirestore
import com.cunha.myserieslist.model.Episodio
import kotlinx.android.synthetic.main.details_episodio_fragment.*
import kotlinx.android.synthetic.main.details_serie_fragment.*
import kotlinx.coroutines.launch

class DetailsEpisodioFragment : Fragment() {

    private lateinit var viewModel: DetailsEpisodioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.details_episodio_fragment, container, false)
        viewModel = ViewModelProvider(this).get(DetailsEpisodioViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (EpisodioUtil.episodioSelecionado != null)

        viewModel.viewModelScope.launch {
            preencherDetails(EpisodioUtil.episodioSelecionado!!)
        }

        fabDeleteEpisode.setOnClickListener {
            viewModel.viewModelScope.launch {
                deletarEpisodio(EpisodioUtil.episodioSelecionado!!)
                findNavController().popBackStack()
            }
        }

        fabEditEpisodio.setOnClickListener {
            findNavController().navigate(R.id.formEpisodioFragment)
        }

    }

    private suspend fun preencherDetails(episodio: Episodio){

        textViewNomeEpisodio.setText(episodio.nome)
        textViewNumeroEpisodio.setText(episodio.numeroEp)
        textViewSinopseEpisodio.setText(episodio.sinopse)
        //var serie = SerieDaoFirestore().read(episodio.serieId!!)
        //textViewSNEpisodio.setText(serie.nome)

    }

    private suspend fun deletarEpisodio(episodio: Episodio){
        //val episodioDao = AppDatabase.getInstance(requireContext().applicationContext).episodioDao()
        //episodioDao.delete(episodio)
    }

}