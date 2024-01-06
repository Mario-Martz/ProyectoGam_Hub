package com.example.proyectovenusappfinal.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


@Composable
fun DefaultOutlinedTextField(
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    colorText: Color = Color.White,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier,
    textStyle: TextStyle = TextStyle.Default,
    focusedBorderColor: Color = Color.Cyan,
    unfocusedBorderColor: Color = Color.Magenta
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = label,
                color = colorText
            )
        },
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        textStyle = textStyle,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unfocusedBorderColor,
        )
    )
}




