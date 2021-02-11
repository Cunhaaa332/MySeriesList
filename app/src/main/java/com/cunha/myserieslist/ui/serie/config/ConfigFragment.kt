package com.cunha.myserieslist.ui.serie.config

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cunha.myserieslist.R
import kotlinx.android.synthetic.main.config_fragment.*
import java.io.File

class ConfigFragment : Fragment() {

    private lateinit var viewModel: ConfigViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.config_fragment, container, false)
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
                if(file.canRead())
                    textViewLegivel.text = "Sim"
                else
                    textViewLegivel.text = "Não"
                if(file.canWrite()) {
                    textViewEditavel.text = "Sim"
                    escreverEmArquivo(file.name, "Mensagem teste.")
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
    private fun escreverEmArquivo(nome: String, msg: String){
        val fileOutputStream = requireActivity().openFileOutput(nome, Context.MODE_APPEND)

        fileOutputStream.write(msg.toByteArray())
    }

}