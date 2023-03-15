package com.lulu.currentconverter.controller

import androidx.compose.runtime.mutableStateOf

import com.lulu.currentconverter.http.Requisicao

class Controller (doll: Double = 1.0, eur: Double = 1.0){
    private val requisicao: Requisicao = Requisicao()

 //   var textBitcoin = mutableStateOf("1.0")

    var textReal = mutableStateOf("1.0")
    var textDollar = mutableStateOf(doll.toString())
    var textEuro = mutableStateOf(eur.toString())

    //private var real: Double? = null
    private var dollar: Double? = doll
    private var euro: Double? = eur
   // private var bitcoin: Double? = 20000.0

    fun alterarReal(it: String) {
        textReal.value = it
        if (it.isEmpty()) {
            clearAll()
        } else {
            val real = it.toDouble()
            //  dollar = real* dollar!!
            textDollar.value = (real / dollar!!).toString()
            textEuro.value = (real / euro!!).toString()
     //       textBitcoin.value = (real / bitcoin!!).toString()
        }
    }

    fun alterarDollar(it: String) {
        textDollar.value = it
        if (it.isEmpty()) {
            clearAll()
        } else {
            val dol = it.toDouble()
            //  dollar = real* dollar!!
            textReal.value = (dollar!! * dol).toString()
            textEuro.value = (dollar!! * dol / euro!!).toString()
        //    textBitcoin.value = (dol / bitcoin!!).toString()
        }
    }


    fun alterarEuro(it: String) {
        textEuro.value = it
        if (it.isEmpty()) {
            clearAll()
        } else {
            val eu = it.toDouble()
            //  dollar = real* dollar!!
            textReal.value = (euro!! * eu).toString()
            textDollar.value = (euro!! * eu / dollar!!).toString()
         //   textBitcoin.value = (eu / bitcoin!!).toString()
        }
    }


    private fun clearAll() {
        textDollar.value = ""
        textEuro.value = ""
      //  textBitcoin.value = ""
    }
}