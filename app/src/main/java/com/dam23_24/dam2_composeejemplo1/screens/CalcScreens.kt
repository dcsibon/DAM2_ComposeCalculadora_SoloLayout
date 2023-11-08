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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam23_24.dam2_composeejemplo1.R


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
            ScreenBtn0_3()

            //Segunda fila de botones del 4 al 7.
            ScreenBtn4_7()

            //Tercera fila de botones: 8, 9, punto decimal (.) y Reset (C).
            ScreenBtn8_C()

            //Cuarta fila de botones: operaciones sumar (+), restar(-) y ejecutar cálculo (=).
            ScreenBtnOper_Res()

            //Quinta fila de botones: operaciones sumar (*), restar(/) y borrar dígito (<).
            ScreenBtnOper_Del()
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
            .padding(top = 50.dp, start = 50.dp, end = 50.dp)
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
 * Función Composable que genera el layout de los botones del 0 al 3 de la primera fila.
 */
@Composable
private fun ScreenBtn0_3() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 40.dp, end = 20.dp, bottom = 40.dp)
    ) {
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn0), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn1), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn2), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn3), fontSize = 32.sp)
        }
    }
}


/**
 * Función Composable que genera el layout de los botones del 4 al 7 de la segunda fila.
 */
@Composable
fun ScreenBtn4_7() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 40.dp)
    ) {
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn4), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn5), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn6), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn7), fontSize = 32.sp)
        }
    }
}


/**
 * Función Composable que genera el layout de los botones 8, 9, punto decimal (.) y
 * reset (C) de la tercera fila.
 */
@Composable
fun ScreenBtn8_C() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 40.dp)
    ) {
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn8), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btn9), fontSize = 32.sp)
        }
        Button(
            //El punto decimal se trata con el número 10 en el método tecleaDigito del objeto calc.
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btnDec), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btnCE), fontSize = 32.sp)
        }
    }
}


/**
 * Función Composable que genera el layout de los botones de los operadores sumar (+),
 * restar (-) y resultado (=) de la cuarta fila.
 */
@Composable
fun ScreenBtnOper_Res() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 40.dp)
    ) {
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btnSuma), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btnResta), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .width(160.dp)
                .height(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btnResult), fontSize = 32.sp)
        }
    }
}


/**
 * Función Composable que genera el layout de los botones de los operadores multiplicar (*), dividir (/) y
 * borrar dígito (<) de la última fila.
 */
@Composable
fun ScreenBtnOper_Del() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 40.dp)
    ) {
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btnMul), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.size(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btnDiv), fontSize = 32.sp)
        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .width(160.dp)
                .height(80.dp)
        ) {
            Text(text = stringResource(R.string.txt_btnBorrar), fontSize = 32.sp)
        }
    }
}