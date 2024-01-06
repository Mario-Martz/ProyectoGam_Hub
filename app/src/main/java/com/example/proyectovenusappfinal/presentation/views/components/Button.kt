package com.example.proyectovenusappfinal.presentation.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyectovenusappfinal.R

@Composable
fun ButtonIngresar(){
    Button(
        modifier = Modifier
            .width(300.dp),
        onClick = {

        },
        colors = ButtonDefaults.buttonColors(Color.Magenta),
        content = { Text("Ingresar") }
    )
}

@Composable
fun ButtonGoogle(){
    Button(
        modifier = Modifier
            .height(40.dp)
            .width(300.dp),
        onClick = { },
        colors = ButtonDefaults.buttonColors(Color.White)) {
        Image(
            painterResource(id = R.drawable.logo_google),
            contentDescription = "Logo de google",
            modifier = Modifier
                .size(40.dp))
        Text(text = "Sign in with Google", color = Color.Black)
    }
}

@Composable
fun ButtonFacebock(){
    Button(
        modifier = Modifier
            .height(40.dp)
            .width(300.dp),
        onClick = { },
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.btn_faceboock))
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_faceboock),
            contentDescription = "Logo de Facebook",
            modifier = Modifier
                .size(40.dp)
        )
        Text(text = "Sign in with Facebook", color = Color.Black)
    }

}