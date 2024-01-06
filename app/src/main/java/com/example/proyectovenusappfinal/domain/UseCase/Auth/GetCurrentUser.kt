package com.example.proyectovenusappfinal.domain.UseCase.Auth

import com.example.proyectovenusappfinal.domain.Repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository){

    operator fun invoke() = repository.currentUser
}