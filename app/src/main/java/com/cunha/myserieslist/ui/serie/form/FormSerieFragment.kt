package com.cunha.myserieslist.ui.serie.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cunha.myserieslist.R
import kotlinx.android.synthetic.main.form_serie_fragment.*

class FormSerieFragment : Fragment() {

    private lateinit var viewModel: FormSerieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.form_serie_fragment, container, false)

        viewModel = ViewModelProvider(this).get(FormSerieViewModel::class.java)

        viewModel.let {
            it.message.observe(viewLifecycleOwner){ message->
                if (!message.isNullOrBlank()){
                    Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
                }
            }
            it.status.observe(viewLifecycleOwner){ status ->
                if(status)
                    findNavController().popBackStack()
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabSaveSerie.setOnClickListener{
            val nome = editTextNomeSerie.text.toString()
            val data = editTextDataSerie.text.toString()
            val sinopse = editTextSinopseSerie.text.toString()
            val nota = editTextNotaSerie.text.toString()

            viewModel.saveSerie(nome,data,sinopse,nota)


        }
    }

}