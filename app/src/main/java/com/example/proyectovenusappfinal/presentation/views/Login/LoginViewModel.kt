package com.example.proyectovenusappfinal.presentation.views.Login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    var email :MutableState<String> = mutableStateOf("")
    var password :MutableState<String> = mutableStateOf("")
}