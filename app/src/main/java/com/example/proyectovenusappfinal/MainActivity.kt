package com.example.proyectovenusappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.proyectovenusappfinal.ui.theme.ProyectoVenusAppFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoVenusAppFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgroundImage()
                    lOGO_Y_REGISTRO()

                }
            }
        }
    }
}

@Composable
fun BackgroundImage() {
    // Obtenemos la ubicacion de la imagen que usaremos de fodno
    val backgroundLogin = painterResource(id = R.drawable.loging_img)
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Image composable with contentScale and contentDescription
        Image(
            painter = backgroundLogin,
            contentDescription = "Imagen de fodno de la app",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun lOGO_Y_REGISTRO() {
    //Creamos las variables de Email y de password
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //Usamos un ConstrainLayout para enganchar los cajas del login y el registro de los usuarios
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (BoxLogo, BoxRegistrer) = createRefs()
        //Creamos un Box donde Guardaremos el logo
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .constrainAs(BoxLogo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            //Alineamos el Box en la parte superior y al centro del dispocitivo
            Alignment.TopCenter,
        ) {
            Image(
                //Optenemos la imagen almacenada en la carpeta drawable
                painter = painterResource(id = R.drawable.logo_v5),
                //le damos una descripcion a la imagen
                contentDescription = "Logo de la app",
                modifier = Modifier
                    //Modificamos la forma de la imagen del logo
                    .clip(CircleShape)
                    //Establecemos un tamaño para la imagen
                    .size(180.dp),        )
        }
        Box(
            modifier = Modifier
                .constrainAs(BoxRegistrer){
                    top.linkTo(BoxLogo.bottom)
                }
        ){
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .statusBarsPadding(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            text = "Email",
                            // Establecemos el color del texto a verde
                            color = Color.White
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    textStyle = TextStyle(color = Color.Magenta),
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = contentColorFor(Color.Magenta),
                        focusedBorderColor = Color.Magenta,
                        unfocusedBorderColor = Color.Magenta,
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = "Password",
                            // Establecemos el color del texto a verde
                            color = Color.White
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    textStyle = TextStyle(color = Color.Magenta),
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = contentColorFor(Color.Magenta),
                        focusedBorderColor = Color.Magenta,
                        unfocusedBorderColor = Color.Magenta,
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier
                        .width(300.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(Color.Magenta),
                    content = { Text("Ingresar") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Uso de ClickableText para hacer el texto "Regístrate aquí" cliclable
                ClickableText(
                    text = AnnotatedString("¿No tienes cuenta? Regístrate aquí"),
                    onClick = { offset ->
                        // Lógica a realizar cuando se hace clic en el texto
                    },
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(color = Color.LightGray)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "o",
                    color = Color.LightGray)
                Spacer(modifier = Modifier.height(10.dp))
                //Ceamos dos botones para iniciar cecion con google o con Faceboock
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
                Spacer(modifier = Modifier.height(18.dp))
                //Ceamos dos botones para iniciar cecion con google o con Faceboock
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
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ProyectoVenusAppFinalTheme {
        BackgroundImage()
        lOGO_Y_REGISTRO()
    }
}