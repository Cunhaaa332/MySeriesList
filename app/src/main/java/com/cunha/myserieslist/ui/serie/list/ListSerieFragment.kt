package com.cunha.myserieslist.ui.serie.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.R
import kotlinx.android.synthetic.main.list_serie_fragment.*

class ListSerieFragment : Fragment() {

    private lateinit var viewModel: ListSerieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_serie_fragment, container, false)

        viewModel = ViewModelProvider(this).get(ListSerieViewModel::class.java)
        viewModel.series.observe(viewLifecycleOwner){
            listViewSerie.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
        }
        viewModel.attListSeries()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}