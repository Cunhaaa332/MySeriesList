package com.cunha.myserieslist.ui.episodio.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cunha.myserieslist.R
import com.cunha.myserieslist.database.AppDatabase
import com.cunha.myserieslist.database.EpisodioDaoFirestore
import com.cunha.myserieslist.database.EpisodioUtil
import com.cunha.myserieslist.database.SerieUtil
import com.cunha.myserieslist.model.Episodio
import kotlinx.android.synthetic.main.form_episodio_fragment.*

class FormEpisodioFragment : Fragment() {

    private lateinit var viewModel: FormEpisodioViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.form_episodio_fragment, container, false)

        val formEpisodioViewModelFactory = FormEpisodioViewModelFactory(EpisodioDaoFirestore())
        viewModel = ViewModelProvider(this, formEpisodioViewModelFactory).get(FormEpisodioViewModel::class.java)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (EpisodioUtil.episodioSelecionado != null)
            preencherFormulario(EpisodioUtil.episodioSelecionado!!)

        fabSaveEpisodio.setOnClickListener{
            val nome = editTextNomeEpisodio.text.toString()
            val numero = editTextNumeroEpisodio.text.toString()
            val sinopse = editTextSinopseEpisodio.text.toString()
            val nota = editTextNotaEpisodio.text.toString()

            viewModel.saveEpisodio(nome, numero, sinopse, nota)
            findNavController().popBackStack()
        }
    }
    private fun preencherFormulario(episodio: Episodio){
        editTextNomeEpisodio.setText(episodio.nome)
        editTextNumeroEpisodio.setText(episodio.numeroEp!!)
        editTextSinopseEpisodio.setText(episodio.sinopse)
        editTextNotaEpisodio.setText(episodio.nota)
    }

}