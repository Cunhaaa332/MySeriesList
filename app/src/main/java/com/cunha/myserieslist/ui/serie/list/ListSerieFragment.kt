package com.cunha.myserieslist.ui.serie.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cunha.myserieslist.LogRegister
import com.cunha.myserieslist.R
import com.cunha.myserieslist.adapter.RecyclerListSerie
import com.cunha.myserieslist.database.AppDatabase
import com.cunha.myserieslist.database.SerieUtil
import com.cunha.myserieslist.model.Serie
import kotlinx.android.synthetic.main.list_serie_fragment.*

class ListSerieFragment : Fragment() {

    private lateinit var viewModel: ListSerieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_serie_fragment, container, false)

        LogRegister.getInstance(requireContext()).escreveLog("ListSerie Fragment acaba de ser acessado!")


        val serieDao = AppDatabase.getInstance(requireContext().applicationContext).serieDao()
        val listSerieViewModelFactory = ListSerieViewModelFactory(serieDao)

        viewModel = ViewModelProvider(this, listSerieViewModelFactory).get(ListSerieViewModel::class.java)
        viewModel.series.observe(viewLifecycleOwner){
            recyclerViewListSerie.adapter = RecyclerListSerie(it)
            recyclerViewListSerie.layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.attListSeries()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fabFormSerie.setOnClickListener{
            SerieUtil.serieSelecionada = null
            findNavController().navigate(R.id.formSerieFragment)
        }
        fabConfig.setOnClickListener{
            findNavController().navigate(R.id.configFragment)
        }
    }

}