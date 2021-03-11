package com.cunha.myserieslist.database

import com.cunha.myserieslist.model.Usuario
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

object UsuarioFirebaseDao {
    val firebaseAuth= FirebaseAuth.getInstance()
    private val collection = FirebaseFirestore.getInstance().collection("usuarios")

    fun cadastrarCredenciais(email: String, senha: String): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, senha)
    }

    fun cadastrarPerfil(uid: String,nome: String, telefone:String): Task<Void> {
        return collection.document(uid).set(Usuario(nome, telefone))
    }

    fun verificarCredenciais(email: String, senha: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, senha)
    }

    fun encerrarSessao() {
        firebaseAuth.signOut()
    }

    fun consultarUsuario(): Task<DocumentSnapshot> {
        val firebaseUser = firebaseAuth.currentUser
        return collection.document(firebaseUser!!.uid).get()
    }
}