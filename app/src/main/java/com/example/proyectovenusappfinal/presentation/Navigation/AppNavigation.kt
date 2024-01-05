package com.example.proyectovenusappfinal.presentation.Navigation

import LoginPrincipal
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proyectovenusappfinal.presentation.views.Login.PantallaRegisterUser

@Composable
fun AppNavigation (navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.router){
        composable(route = AppScreen.Login.router){
            LoginPrincipal(navController)
        }
        composable(route = AppScreen.Register.router ){
            PantallaRegisterUser(navController)
        }
    }

}