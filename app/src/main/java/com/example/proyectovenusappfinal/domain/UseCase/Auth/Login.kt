package com.example.proyectovenusappfinal.domain.UseCase.Auth

import com.example.proyectovenusappfinal.domain.Repository.AuthRepository
import javax.inject.Inject


class Login @Inject constructor(private  val repository: AuthRepository){


    suspend operator fun invoke(email: String,password :String) = repository.login(email,password)
}