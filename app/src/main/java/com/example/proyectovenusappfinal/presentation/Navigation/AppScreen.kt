package com.example.proyectovenusappfinal.presentation.Navigation

sealed class AppScreen(var router: String) {
    object Login: AppScreen("Login")
    object Register :AppScreen("Registrar")
}