package com.example.proyectovenusappfinal.presentation.views.Login

import android.annotation.SuppressLint
import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectovenusappfinal.R
import com.example.proyectovenusappfinal.presentation.Navigation.AppScreen
import java.util.regex.Pattern

@Composable
fun PantallaRegisterUser(navigationController: NavHostController) {
    val Navegacion = navigationController
    BackgroundImageRegister()
    FormulRegister(Navegacion)
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

@SuppressLint("SuspiciousIndentation")
@Composable
fun FormulRegister(Navegacion: NavHostController){

    //Variables para los campos OutlinedTextField
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //Variable para almacenar el logo de
    val img_User = painterResource(id = R.drawable.img_user)

    //Vandera para validar si los campos estan o no vacios (NULL)
    var showNombreIcon by remember { mutableStateOf(false) }
    var nombreError by remember { mutableStateOf<String?>(null) }

    var showApellidoIcon by remember { mutableStateOf(false) }
    var apellidoError by remember { mutableStateOf<String?>(null) }

    var showtelefonoIcon by remember { mutableStateOf(false) }
    var telefonoError by remember { mutableStateOf<String?>(null) }

    var showEmailIcon by remember{ mutableStateOf(false) }
    var emailError by remember{ mutableStateOf<String?>(null) }

    var showPasswordIcon by remember{ mutableStateOf(false) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (BoxTitulo,BoxContenido) = createRefs()
            Box(modifier = Modifier
                .constrainAs(BoxTitulo){
                       start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top, margin = 20.dp)
                }
                ,contentAlignment = Alignment.Center){
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .height(180.dp),
                    painter = img_User,
                    contentDescription = "Logo de la empresa")
            }
        Box(modifier = Modifier
            .constrainAs(BoxContenido){
                top.linkTo(BoxTitulo.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }){
            Column(modifier = Modifier
                .padding(16.dp)
                .statusBarsPadding(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = {
                            nombre = it
                            showNombreIcon = false
                            nombreError = null //Limpiamos el mensaje de error
                        },
                        label = {
                            Text(
                                text = "Nombre",
                                color = Color.White
                            )
                        },
                        // Colocamos un Icon
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Person Icon",
                                tint = Color.White
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp),
                        textStyle = TextStyle(color = Color.Magenta),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Cyan,
                            unfocusedBorderColor = Color.Magenta,
                        )
                    )
                    if (showNombreIcon) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .background(Color.Black)
                                .border(1.dp, Color.Red)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_warnig),
                                contentDescription = "Error Campo obligatorio",
                                tint = Color.Yellow
                            )
                            Text(
                                text = nombreError ?: "",
                                color = Color.Yellow
                            )
                        }
                    }
                Spacer(modifier = Modifier.height(2.dp))
                OutlinedTextField(
                    value = apellido,
                    onValueChange = {
                        apellido = it
                        //Limpiamos el mensaje de error y el icon de error
                        showApellidoIcon = false
                        apellidoError = null
                                    },
                    label = {
                        Text(
                            text = "Apellido`s",
                            color = Color.White
                            )
                    },
                    //Colocamos un icon
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person,
                            contentDescription = "Appellido Icon",
                            //Camviamos de color
                            tint = Color.White)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    //Editamos el color del texto que aparecera al escribir en el campo
                    textStyle = TextStyle(color = Color.Magenta),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Cyan,
                        unfocusedBorderColor = Color.Magenta
                    )
                )
                //validamos que el campo de Nombre no este vacio o sea null
                if(showApellidoIcon){
                    Row (
                        modifier = Modifier
                            .background(Color.Black)
                            .border(1.dp, Color.Red))
                    {
                        Icon(imageVector = Icons.Default.Warning,
                            contentDescription = "Errro canpo nombre vacio",
                            tint = Color.Yellow
                        )
                        Text(text = apellidoError ?: "",
                            color = Color.Yellow)
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                OutlinedTextField(
                    value = telefono,
                    onValueChange = {
                                    telefono = it
                                    showtelefonoIcon = false
                                    telefonoError = null
                                    },
                    label = {
                        Text(text = "Telefono",
                            color = Color.White)
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Phone,
                            contentDescription = "Icon Phone",
                            tint = Color.White)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    //Editamos el color del texto interno del componente
                    textStyle = TextStyle(color = Color.Magenta),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Cyan,
                        unfocusedBorderColor = Color.Magenta
                    )
                )
                if(showtelefonoIcon){
                    Row(modifier = Modifier
                        .background(Color.Black)
                        .border(1.dp, Color.Red))
                    {
                        Icon(imageVector = Icons.Default.Warning,
                            contentDescription = "Icon de error",
                            tint = Color.Yellow)
                        Text(text = telefonoError?:"",
                            color = Color.Yellow)
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                                    email = it
                                    showEmailIcon = false
                                    emailError = null
                                    },
                    label = {
                        Text(text = "Email",
                            color = Color.White
                        )
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email,
                            contentDescription = "Email icon",
                            tint = Color.White
                        )
                    },
                    //Tipo de datos que se va a ingresar
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    textStyle = TextStyle(color = Color.Magenta),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Cyan,
                        unfocusedBorderColor = Color.Magenta
                    )
                )
                if(showEmailIcon){
                    Row (modifier = Modifier
                        .background(Color.Black)
                        .border(1.dp, Color.Red)){
                        Icon(imageVector = Icons.Default.Warning,
                            contentDescription = "Error Email",
                            tint = Color.Yellow)
                        Text(text = emailError?:"",
                            color = Color.Yellow)
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                                    password = it
                                    showPasswordIcon = false
                                    passwordError = null
                                    },
                    label = {
                        Text(
                            text = "Password",
                            color = Color.White
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Icon contraseña",
                            tint = Color.White)
                    },
                    //Tipo de dato
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    textStyle = TextStyle(Color.Magenta),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Cyan,
                        unfocusedBorderColor = Color.Magenta
                    )
                )
                if(showPasswordIcon){
                    Row(modifier = Modifier
                        .background(Color.Black)
                        .border(1.dp, Color.Red)) {
                        Icon(imageVector = Icons.Default.Warning,
                            contentDescription = "Error Icon password",
                            tint = Color.Yellow)
                        Text(
                            text = passwordError ?: "",
                            color = Color.Yellow
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    onClick = {
                        nombreError = if (nombre.isEmpty()) "Campo obligatorio" else null
                        showNombreIcon = nombreError != null

                        apellidoError = if(apellido.isEmpty()) "Campo obligatorio" else null
                        showApellidoIcon = apellidoError != null

                        telefonoError = if(telefono.isEmpty()) "Campo obligatorio" else null
                        showtelefonoIcon = telefonoError != null

                        emailError = when{
                            email.isEmpty() -> "Campo obligatorio"
                            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "El  Email no es valido"
                            else -> null
                        }
                        showEmailIcon = emailError != null

                        passwordError = when {
                            password.isEmpty() -> "Campo obligatorio"
                            password.length < 8 -> "La contraseña debe tener al menos 8 caracteres"
                            !validarContrasena(password) -> "Contraseña no válida. Debe contener al menos una letra, un número, un carácter especial"
                            else -> null
                        }
                        showPasswordIcon = passwordError != null


                        //Verificamos si todos los campos esta llenos
                        if(nombreError == null && apellidoError == null && telefonoError == null && emailError == null && passwordError ==null){
                            Toast.makeText(context, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show()
                            //Regresamos a la pantalla Login
                            Navegacion.navigate(route = AppScreen.Login.router)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Magenta)) {
                    Text(text = "Registrarse")
                }
            }
        }
    }
}

fun validarContrasena(contrasena: String): Boolean {
    val patron = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
    val matcher = Pattern.compile(patron).matcher(contrasena)
    return matcher.matches()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaRegister() {
    PantallaRegisterUser(rememberNavController())
}