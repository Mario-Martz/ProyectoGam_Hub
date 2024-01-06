package com.example.proyectovenusappfinal.domain.UseCase.Auth

class AuthUseCase (
    //Optenemos el usuario Actual
    val getCurrentUser:GetCurrentUser,
     //Funcion de login
    val login:Login
)