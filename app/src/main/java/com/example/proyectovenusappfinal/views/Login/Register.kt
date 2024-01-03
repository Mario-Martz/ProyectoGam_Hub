package com.example.proyectovenusappfinal.views.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.proyectovenusappfinal.R

@Composable
fun PantallaRegisterUser(navigationController: NavHostController) {
    BackgroundImageRegister()
    FormulRegister()
}

@Composable
fun BackgroundImageRegister(){
    //Obtenemos la direccion de la imagen para usar como fondo de pantalla
    val imgREgister = painterResource(id = R.drawable.img_register)
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = imgREgister,
            contentDescription = "Fondo de pantalla del Registro de usuarios",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop)
    }
}

@Composable
fun FormulRegister(){

    var Nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (BoxTitulo,BoxContenido) = createRefs()
        Column (modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Box(modifier = Modifier
                .fillMaxWidth()
                , contentAlignment = Alignment.Center){
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = "Bienvenido",
                    fontSize = 60.sp,
                    style = TextStyle(color = Color.Magenta)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier,
                contentAlignment = Alignment.TopCenter){
                //Text(text = "Hola Mundo")
                OutlinedTextField(
                    value = Nombre,
                    onValueChange = { Nombre = it },
                    label = {
                        Text(text = "Nombre",
                            color = Color.White)
                    }
                )
            }
            Box(modifier = Modifier,
                contentAlignment = Alignment.TopCenter){
                //Text(text = "Hola Mundo")
                OutlinedTextField(
                    value = Nombre,
                    onValueChange = { Nombre = it },
                    label = {
                        Text(text = "Nombre",
                            color = Color.White)
                    }
                )
            }
            Box(modifier = Modifier,
                contentAlignment = Alignment.TopCenter){
                //Text(text = "Hola Mundo")
                OutlinedTextField(
                    value = Nombre,
                    onValueChange = { Nombre = it },
                    label = {
                        Text(text = "Nombre",
                            color = Color.White)
                    }
                )
            }
            Box(modifier = Modifier,
                contentAlignment = Alignment.TopCenter){
                //Text(text = "Hola Mundo")
                OutlinedTextField(
                    value = Nombre,
                    onValueChange = { Nombre = it },
                    label = {
                        Text(text = "Nombre",
                            color = Color.White)
                    }
                )
            }
        }
    }
}

