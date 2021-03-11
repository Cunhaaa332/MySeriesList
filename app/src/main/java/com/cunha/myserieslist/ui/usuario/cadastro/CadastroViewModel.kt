package com.cunha.myserieslist.ui.usuario.cadastro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cunha.myserieslist.database.UsuarioFirebaseDao
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class CadastroViewModel : ViewModel() {
    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    fun salvarCadastro(email: String, password: String, nome: String, telefone: String) {
        UsuarioFirebaseDao.cadastrarCredenciais(email, password).addOnSuccessListener {
            val uid = it.user!!.uid
            UsuarioFirebaseDao.cadastrarPerfil(uid, nome, telefone).addOnSuccessListener {
                _status.value = true
                _msg.value = "Usuario cadastrado com sucesso!"
            }.addOnFailureListener {
                _msg.value = "${it.message}"
            }

        }.addOnFailureListener {
                _msg.value = "${it.message}"
        }
    }
}