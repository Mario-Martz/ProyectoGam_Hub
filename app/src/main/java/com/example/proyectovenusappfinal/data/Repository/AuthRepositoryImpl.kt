package com.example.proyectovenusappfinal.data.Repository

import com.example.proyectovenusappfinal.domain.Model.Response
import com.example.proyectovenusappfinal.domain.Repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth ):AuthRepository{

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
       return try {
           val resoul = firebaseAuth.signInWithEmailAndPassword(email,password).await()
           Response.Success(resoul.user!!)
       }catch (e: Exception){
           e.printStackTrace()
           Response.Errors(e)
       }
    }
}