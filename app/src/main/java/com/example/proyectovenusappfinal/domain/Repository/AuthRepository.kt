package com.example.proyectovenusappfinal.domain.Repository

import com.example.proyectovenusappfinal.domain.Model.Response
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    //Creamos metodos de auntentificacion y de usuario
    val currentUser : FirebaseUser?

    suspend fun login(email: String, password: String):Response<FirebaseUser>
}