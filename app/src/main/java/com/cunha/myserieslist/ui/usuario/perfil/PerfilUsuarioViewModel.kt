package com.cunha.myserieslist.ui.usuario.perfil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cunha.myserieslist.database.UsuarioFirebaseDao
import com.cunha.myserieslist.model.Usuario

class PerfilUsuarioViewModel : ViewModel() {

    private val _usuario = MutableLiveData<Usuario>()
    val usuario: LiveData<Usuario> = _usuario

    init{
        UsuarioFirebaseDao.consultarUsuario().addOnSuccessListener {
            val usuario = it.toObject(Usuario::class.java)
            usuario!!.firebaseUser = UsuarioFirebaseDao.firebaseAuth.currentUser
            _usuario.value = usuario!!
        }
    }

    fun encerrarSessao() {
        UsuarioFirebaseDao.encerrarSessao()
        _usuario.value = null
    }
}