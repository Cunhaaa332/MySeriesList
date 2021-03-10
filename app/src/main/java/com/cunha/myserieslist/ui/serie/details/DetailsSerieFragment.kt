package com.cunha.myserieslist.ui.serie.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.cunha.myserieslist.R
import com.cunha.myserieslist.database.AppDatabase
import com.cunha.myserieslist.database.EpisodioUtil
import com.cunha.myserieslist.database.SerieDaoFirestore
import com.cunha.myserieslist.database.SerieUtil
import com.cunha.myserieslist.model.Episodio
import com.cunha.myserieslist.model.Serie
import com.cunha.myserieslist.ui.serie.list.ListSerieViewModel
import com.cunha.myserieslist.ui.serie.list.ListSerieViewModelFactory
import kotlinx.android.synthetic.main.details_serie_fragment.*
import kotlinx.android.synthetic.main.form_serie_fragment.*
import kotlinx.android.synthetic.main.list_serie_fragment.*
import kotlinx.coroutines.launch

class DetailsSerieFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsSerieFragment()
    }

    private lateinit var viewModel: DetailsSerieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.details_serie_fragment, container, false)

        /*val episodioDao = AppDatabase.getInstance(requireContext().applicationContext).episodioDao()
        val key: Long? = SerieUtil.serieSelecionada?.id
        val detailsSerieFragmentViewModelFactory = DetailsSerieFragmentViewModelFactory(episodioDao, key)
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
        viewModel.allepisodios()*/
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
                deletarSerie(SerieUtil.serieSelecionada!!)
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

    private fun deletarSerie(serie: Serie){
       // val sereiDao = AppDatabase.getInstance(requireContext().applicationContext).serieDao()
       // val episodioDao = AppDatabase.getInstance(requireContext().applicationContext).episodioDao()
      //  sereiDao.delete(serie)
      //  episodioDao.deleteEpisodesOfSerie(serie.id)
        SerieDaoFirestore().delete(serie)
    }

}