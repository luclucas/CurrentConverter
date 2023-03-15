package com.lulu.currentconverter.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.lulu.currentconverter.api.Endpoint
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.launch
import org.json.JSONObject


class MainActivity : ComponentActivity() {



    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
    lateinit var resp: HttpResponse

        var dollar: Double? = 0.0
        var euro: Double? = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            resp = resposta(client)

            onResult(resp.body())
        }


        setContent {
            println("$dollar!! $euro!!")
            Tela(dollar!!, euro!!)
        }
    }

    private fun onResult(result: String) {
        val json = JSONObject(result)
        dollar = json.getJSONObject("results").getJSONObject("currencies").getJSONObject("USD").getDouble("buy")

        euro = json.getJSONObject("results").getJSONObject("currencies").getJSONObject("EUR").getDouble("buy")


        //println(result)
    }

}


suspend fun resposta(client: HttpClient): HttpResponse {
    return client.get(Endpoint.CAMINHO)
}
