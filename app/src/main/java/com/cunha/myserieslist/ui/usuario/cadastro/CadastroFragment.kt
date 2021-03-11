package com.cunha.myserieslist.ui.usuario.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cunha.myserieslist.R
import kotlinx.android.synthetic.main.cadastro_fragment.*

class CadastroFragment : Fragment() {

    private lateinit var viewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cadastro_fragment, container, false)
        viewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it)
                findNavController().popBackStack()
        })

        viewModel.msg.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrBlank())
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCadastroCadastrar.setOnClickListener {
            val email = editTextCadastroEmail.text.toString()
            val senha = editTextCadastroSenha.text.toString()
            val resenha = editTextCadastroConfirmaSenha.text.toString()
            if(senha == resenha){
                viewModel.salvarCadastro(email, senha)
            }else{
                Toast.makeText(requireContext(), "Senhas não batem.", Toast.LENGTH_SHORT).show()
            }

        }
    }

}