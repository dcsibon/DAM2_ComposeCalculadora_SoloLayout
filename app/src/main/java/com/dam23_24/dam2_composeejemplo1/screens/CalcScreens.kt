package com.dam23_24.dam2_composeejemplo1.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Función Composable principal que se llama desde el setContent del MainActivity y contiene
 * los estados y realiza las llamadas a las funciones Composable que componen todos los elementos
 * del layout.
 */
@Preview(showBackground = true)
@Composable
fun CalcScreen() {

    Column(modifier = Modifier.fillMaxSize()) {

        //Text que muestran la información de la pantalla ppal y el detalle.
        ScreenDetailText()

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            //Primera fila de botones del 0 al 3.
            ScreenRowButtons(
                txtBtn = listOf("0", "1", "2", "3"),
                width = listOf(80, 80, 80, 80)
            )

            //Segunda fila de botones del 4 al 7.
            ScreenRowButtons(
                txtBtn = listOf("4", "5", "6", "7"),
                width = listOf(80, 80, 80, 80)
            )

            //Tercera fila de botones: 8, 9, punto decimal (.) y Reset (C).
            ScreenRowButtons(
                txtBtn = listOf("8", "9", ".", "C"),
                width = listOf(80, 80, 80, 80)
            )

            //Cuarta fila de botones: operaciones sumar (+), restar(-) y ejecutar cálculo (=).
            ScreenRowButtons(
                txtBtn = listOf("+", "-", "="),
                width = listOf(80, 80, 160)
            )

            //Quinta fila de botones: operaciones sumar (*), restar(/) y borrar dígito (<).
            ScreenRowButtons(
                txtBtn = listOf("*", "/", "<"),
                width = listOf(80, 80, 160)
            )
        }
    }
}


/**
 * Función Composable que genera el layout de los textos principal y detalle de la calculadora.
 */
@Composable
private fun ScreenDetailText() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 50.dp, end = 50.dp, bottom = 40.dp)
    ) {

        Text(
            text = "",
            textAlign = TextAlign.End,
            fontSize = 50.sp,
            modifier = Modifier
                .border(3.dp, Color.Black)
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "",
            textAlign = TextAlign.End,
            fontSize = 24.sp,
            modifier = Modifier
                .border(3.dp, Color.Black)
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
    }
}


/**
 * Función Composable que genera el layout de una fila de botones.
 */
@Composable
private fun ScreenRowButtons(
    txtBtn: List<String>,
    width: List<Int>
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 40.dp)
    ) {
        for (i in txtBtn.indices) {
            ScreenButton(
                txtBtn = txtBtn[i],
                width = width[i]
            )
        }
    }
}


/**
 * Función Composable que genera el layout de un botón.
 */
@Composable
private fun ScreenButton(
    txtBtn: String,
    width: Int
) {
    Button(
        onClick = { /* TODO */ },
        modifier = Modifier.width(width.dp).height(80.dp)
    ) {
        Text(text = txtBtn, fontSize = 32.sp)
    }
}
