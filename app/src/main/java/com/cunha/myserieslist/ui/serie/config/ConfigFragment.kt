package com.cunha.myserieslist.ui.serie.config

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.LogRegister
import com.cunha.myserieslist.R
import kotlinx.android.synthetic.main.config_fragment.*
import java.io.File

class ConfigFragment : Fragment() {

    private lateinit var viewModel: ConfigViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.config_fragment, container, false)

        LogRegister.getInstance(requireContext()).escreveLog("Config Fragment acaba de ser acessado!")

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConfigViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnVerificaArquivo.setOnClickListener{
            val nomeArquivo = editTextArquivoNome.text.toString()
            val file = File(requireActivity().filesDir, nomeArquivo)
            if(file.exists()) {
                textViewExiste.text = "Sim"
                if(file.canRead()) {
                    textViewLegivel.text = "Sim"
                    lerArquivo(file.name)
                }else
                    textViewLegivel.text = "Não"
                if(file.canWrite()) {
                    textViewEditavel.text = "Sim"
                }
                else
                    textViewEditavel.text = "Não"
            }
            else{
                textViewExiste.setText("Não")
                textViewLegivel.setText("Não")
                textViewEditavel.setText("Não")
                btnCriarArquivo.isEnabled = true
            }
        }

        btnCriarArquivo.setOnClickListener{
            val nomeArquivo = editTextArquivoNome.text.toString()
            val file = File(requireActivity().filesDir, nomeArquivo)
            file.createNewFile()
        }

    }

    private fun lerArquivo (nome: String){
        val fileIS = requireActivity().openFileInput(nome)
        val texto = fileIS.bufferedReader().readText()
        txtConteudoArquivo.text = texto
    }

}