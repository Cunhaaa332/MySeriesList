package com.cunha.myserieslist.ui.serie.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.cunha.myserieslist.R
import com.cunha.myserieslist.api.model.SerieApi
import com.cunha.myserieslist.database.*
import com.cunha.myserieslist.model.Episodio
import com.cunha.myserieslist.model.Serie
import com.cunha.myserieslist.ui.serie.list.ListSerieViewModel
import com.cunha.myserieslist.ui.serie.list.ListSerieViewModelFactory
import kotlinx.android.synthetic.main.details_serie_fragment.*
import kotlinx.android.synthetic.main.form_serie_fragment.*
import kotlinx.android.synthetic.main.list_serie_fragment.*
import kotlinx.coroutines.launch

class DetailsSerieFragment : Fragment() {
    private lateinit var viewModel: DetailsSerieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.details_serie_fragment, container, false)
        val key: String? = SerieUtil.serieSelecionada?.id
        val detailsSerieFragmentViewModelFactory = DetailsSerieFragmentViewModelFactory(EpisodioDaoFirestore(), key)
        viewModel = ViewModelProvider(
            this,
           detailsSerieFragmentViewModelFactory
        ).get(DetailsSerieViewModel::class.java)
        viewModel.episodios.observe(viewLifecycleOwner) {
            listViewEpisodios.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
            listViewEpisodios.setOnItemClickListener { parent, view, position, id ->
                val episodio = it.get(position)
                EpisodioUtil.episodioSelecionado = episodio
                findNavController().navigate(R.id.detailsEpisodioFragment)
            }
        }
        viewModel.serieApi.observe(viewLifecycleOwner, Observer {
            if(SerieUtil.serieSelecionada!!.nome == it.name){
                textViewImdbRating.setText(it.rating!!.average.toString())
            }else{
                textViewImdbRating.setText("Série não encontrada no Imdb.")
            }

        })
        viewModel.allepisodios()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (SerieUtil.serieSelecionada != null)
            preencherDetails(SerieUtil.serieSelecionada!!)

        fabEditSerie.setOnClickListener {
            findNavController().navigate(R.id.formSerieFragment)
        }
        fabDeleteSerie.setOnClickListener{
                viewModel.deleteEpisodes()
                SerieDaoFirestore().delete(SerieUtil.serieSelecionada!!)
                findNavController().popBackStack()

        }
        fabAddEpisodio.setOnClickListener{
            EpisodioUtil.episodioSelecionado = null
            findNavController().navigate(R.id.formEpisodioFragment)
        }
    }

    private fun preencherDetails(serie: Serie){
        textViewNomeSerie.setText(serie.nome)
        textViewDataSerie.setText(serie.dataLancamento)
        textViewSinopseSerie.setText(serie.sinopse)
        textViewNotaSerie.setText(serie.nota)
        textViewIDSerie.setText(serie.id)
    }
}