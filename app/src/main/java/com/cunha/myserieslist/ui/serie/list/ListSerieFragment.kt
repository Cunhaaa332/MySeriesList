package com.cunha.myserieslist.ui.serie.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cunha.myserieslist.LogRegister
import com.cunha.myserieslist.R
import com.cunha.myserieslist.adapter.RecyclerListSerie
import com.cunha.myserieslist.database.SerieDaoFirestore
import com.cunha.myserieslist.database.SerieUtil
import kotlinx.android.synthetic.main.list_serie_fragment.*

class ListSerieFragment : Fragment() {

    private lateinit var viewModel: ListSerieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_serie_fragment, container, false)

        LogRegister.getInstance(requireContext()).escreveLog("ListSerie Fragment acaba de ser acessado!")

        val listSerieViewModelFactory = ListSerieViewModelFactory(SerieDaoFirestore())

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