package com.example.proyectovenusappfinal.presentation.views.Login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectovenusappfinal.domain.Model.Response
import com.example.proyectovenusappfinal.domain.UseCase.Auth.AuthUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var email :MutableState<String> = mutableStateOf("")
    var password :MutableState<String> = mutableStateOf("")

    fun login() = viewModelScope.launch{
        _loginFlow.value = Response.Loading
        val result = authUseCase.login(email.value,password.value)
        _loginFlow.value = result
    }

    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow:StateFlow<Response<FirebaseUser>?> = _loginFlow
}