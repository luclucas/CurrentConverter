package com.lulu.currentconverter.view

import android.annotation.SuppressLint
import android.service.controls.Control
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.currentconverter.controller.Controller
import com.lulu.currentconverter.http.Requisicao

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Tela(dollar: Double, euro: Double) {

    val ctrl = Controller(dollar, euro)

    Scaffold(
        topBar = { TopAppBar() }, modifier = Modifier.background(color = Color.Red)

    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "$",
                modifier = Modifier
                    .padding(30.dp)
                    .background(color = Color.Yellow, shape = CircleShape)
                    .padding(20.dp),
                fontSize = 30.sp
            )

            OutlinedTextField(
                modifier = Modifier.padding(bottom = 30.dp),
                value = ctrl.textReal.value,
                onValueChange = {
                    ctrl.alterarReal(it)
                    Log.e("Bom dia", ctrl.textReal.value)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                label = { Text(text = "Reais", color = Color.Yellow) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Yellow,
                    unfocusedBorderColor = Color.Yellow,
                    textColor = Color.White
                ),

                )

            OutlinedTextField(
                modifier = Modifier.padding(bottom = 30.dp),
                value = ctrl.textDollar.value,
                onValueChange = {
                    ctrl.alterarDollar(it)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                label = { Text(text = "Dólar", color = Color.Yellow) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Yellow,
                    unfocusedBorderColor = Color.Yellow,
                    textColor = Color.White
                ),

                )
            OutlinedTextField(
                modifier = Modifier.padding(bottom = 30.dp),
                value = ctrl.textEuro.value,
                onValueChange = {
                    ctrl.alterarEuro(it)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                label = { Text(text = "Euro", color = Color.Yellow) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Yellow,
                    unfocusedBorderColor = Color.Yellow,
                    textColor = Color.White
                ),

                )
//
//            OutlinedTextField(
//                modifier = Modifier.padding(bottom = 30.dp),
//                value = ctrl.textBitcoin.value,
//                onValueChange = {
//                    ctrl.textBitcoin.value = it
//                },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
//                label = { Text(text = "Bitcoin", color = Color.Yellow) },
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Yellow,
//                    unfocusedBorderColor = Color.Yellow,
//                    textColor = Color.White
//                ),
//
//                )

        }
    }

}


@Composable
fun TopAppBar() {
    TopAppBar(
        Modifier
            .fillMaxWidth()
            .background(color = Color.Red)
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = "$ Cotação $", color = Color.Yellow)
        }
    }
}