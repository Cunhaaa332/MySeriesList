package com.cunha.myserieslist.ui.usuario.cadastro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class CadastroViewModel : ViewModel() {
    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    fun salvarCadastro(email: String, password: String) {
        val fireBaseAuth = FirebaseAuth.getInstance()

        val task = fireBaseAuth.createUserWithEmailAndPassword(email, password)
        task.addOnSuccessListener {
            _status.value = true
            _msg.value = "Usuario cadastrado com sucesso!"
        }.addOnFailureListener {
            _msg.value = "${it.message}"
        }
    }
}