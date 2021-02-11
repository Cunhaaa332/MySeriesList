package com.cunha.myserieslist.ui.serie.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.R

class FormSerieFragment : Fragment() {

    companion object {
        fun newInstance() = FormSerieFragment()
    }

    private lateinit var viewModel: FormSerieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_serie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormSerieViewModel::class.java)
        // TODO: Use the ViewModel
    }

}