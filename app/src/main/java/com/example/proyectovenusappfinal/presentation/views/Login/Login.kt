import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectovenusappfinal.R
import com.example.proyectovenusappfinal.domain.Model.Response
import com.example.proyectovenusappfinal.presentation.components.DefaultOutlinedTextField
import com.example.proyectovenusappfinal.presentation.Navigation.AppScreen
import com.example.proyectovenusappfinal.presentation.views.Login.LoginViewModel
import com.example.proyectovenusappfinal.presentation.views.components.ButtonFacebock
import com.example.proyectovenusappfinal.presentation.views.components.ButtonGoogle
import com.example.proyectovenusappfinal.presentation.views.components.ButtonIngresar

@Composable
fun LoginPrincipal(navigationController: NavHostController) {
    val Navegacion = navigationController
    BackgroundImage()
    lOGO_Y_REGISTRO(Navegacion)
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
@Composable
fun lOGO_Y_REGISTRO(Navegacion: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {



    val loginFlow = viewModel.loginFlow.collectAsState()
    //Usamos un ConstrainLayout para enganchar los cajas del login y el registro de los usuarios
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (BoxLogo, BoxRegistrer) = createRefs()
        //Creamos un Box donde Guardaremos el logo
        Box(
            modifier = Modifier
                .padding(top = 50.dp, bottom = 50.dp)
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
                    .size(180.dp),
            )
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
                DefaultOutlinedTextField(
                    value = viewModel.email.value,
                    onValueChange = { viewModel.email.value = it},
                    label = "Email",
                    //leadingIconTint = Color.White,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    textStyle = TextStyle(Color.Magenta),
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.Magenta
                )
                Spacer(modifier = Modifier.height(16.dp))
                var isPasswordVisible by remember { mutableStateOf(false) }
                OutlinedTextField(
                    value = viewModel.password.value,
                    onValueChange = {
                        viewModel.password.value = it
                    },
                    label = {
                        Text(
                            text = "Password",
                            color = Color.White
                        )
                    },
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else
                        PasswordVisualTransformation(),
                    //Tipo de dato
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    trailingIcon = {
                        Icon(
                            tint = Color.White,
                            painter = if (isPasswordVisible) painterResource(id = R.drawable.ic_visibility)
                            else painterResource(id = R.drawable.ic_visibility_off),
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                isPasswordVisible = !isPasswordVisible
                            }
                        )
                    },
                    textStyle = TextStyle(Color.Magenta),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Cyan,
                        unfocusedBorderColor = Color.Magenta
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier
                        .width(300.dp),
                    onClick = {
                        Log.d("Boton Ingresar","EL email es: ${viewModel.email.value} y el password es: ${viewModel.password.value}")
                        viewModel.login()
                    },
                    colors = ButtonDefaults.buttonColors(Color.Magenta),
                    content = { Text("Ingresar") }
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Uso de ClickableText para hacer el texto "Regístrate aquí" cliclable
                ClickableText(
                    text = AnnotatedString("¿No tienes cuenta? Regístrate aquí"),
                    onClick = { Ir_Registro ->
                        // Lógica a realizar cuando se hace clic en el texto
                        Navegacion.navigate(route = AppScreen.Register.router)

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
                ButtonGoogle()
                Spacer(modifier = Modifier.height(18.dp))
                //Ceamos dos botones para iniciar cecion con google o con Faceboock
                ButtonFacebock()

            }
        }
    }
    loginFlow.value.let { state ->
        when (state) {
            //Mostramos al usuario que la peticion se esta cargando
            Response.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }

            is Response.Success -> {
                Toast.makeText(LocalContext.current, "Usuario logeado", Toast.LENGTH_LONG).show()
            }

            is Response.Errors -> {
                Toast.makeText(
                    LocalContext.current,
                    state.exception?.message ?: "Error al tratar de ingresar",
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> {
                Toast.makeText(LocalContext.current, "Hoy no es tu dia de suerte", Toast.LENGTH_LONG).show()

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaLoginPrincipal() {
   // LoginPrincipal(rememberNavController( ))
}

