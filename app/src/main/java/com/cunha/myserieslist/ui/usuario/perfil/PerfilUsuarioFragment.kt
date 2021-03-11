package com.cunha.myserieslist.ui.usuario.perfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cunha.myserieslist.R
import com.cunha.myserieslist.database.UsuarioFirebaseDao
import com.cunha.myserieslist.model.Usuario
import kotlinx.android.synthetic.main.perfil_usuario_fragment.*

class PerfilUsuarioFragment : Fragment() {

    private lateinit var viewModel: PerfilUsuarioViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(PerfilUsuarioViewModel::class.java)
        val view = inflater.inflate(R.layout.perfil_usuario_fragment, container, false)
        viewModel.usuario.observe(viewLifecycleOwner, Observer {
            if(it != null){
                preencherInformacoesPerfil(it)
            }else if(UsuarioFirebaseDao.firebaseAuth.currentUser == null) {
                findNavController().navigate(R.id.loginFragment)
                limparInformacoesPerfil()
            }
        })
        return view
    }

    private fun limparInformacoesPerfil() {
        textViewUserUID.text = null
        textViewUserNome.text =  null
        textViewUserTelefone.text = null
        textViewUserEmail.text = null
    }

    private fun preencherInformacoesPerfil(usuario: Usuario) {
        textViewUserUID.text = usuario.uid
        textViewUserNome.text = usuario.nome
        textViewUserTelefone.text = usuario.telefone
        textViewUserEmail.text = usuario.firebaseUser!!.email


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSair.setOnClickListener {
            viewModel.encerrarSessao()
        }
    }

}