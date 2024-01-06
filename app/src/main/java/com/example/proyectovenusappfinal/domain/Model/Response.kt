package com.example.proyectovenusappfinal.domain.Model

import java.lang.Exception
//Modelamos la respuesta de firebase

//Objeto gemnerico --De cualquier tipo
sealed class Response<out T> {
    object Loading: Response<Nothing>() //Comprovamos que se este ejecutando el proseso de cargra de datos

    data class Success<out T>(val data:T):Response<T>() //Comprovamos si el proceso de loging se ejecuto corectamente
    data class Errors<out T>(val exception: Exception?):Response<T>()
}